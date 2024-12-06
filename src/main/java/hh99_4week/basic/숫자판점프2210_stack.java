package hh99_4week.basic;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숫자판점프2210_stack {

    /*
     * - 모든 경우를 다 파악해야 하므로 DFS로 구현
     * - 중복된 자리를 허용하므로 visited 배열을 기록할 필요는 없다
     * - 다만 경우의 수가 같으면 안 되므로, 6자리 숫자들을 저장할 때에는 Set으로 중복저장을 피한다.
     * - 000으로 시작하는 경우~ 들이 있으므로 String으로 받아서 사용하는 게 편할 것 같다.
     * */
    static String[][] numMap = new String[5][5]; //영역 생성
    static int dx[] = {0, 0, 1, -1}; //상하좌우 x값 이동
    static int dy[] = {1, -1, 0, 0}; //상하좌우 y값 이동
    //배열의 위치가 A[dx[0]][dy[0]] = A[0][1] = 오른쪽으로 1칸
    //배열의 위치가 A[dx[1]][dy[1]] = A[0][-1] = 왼쪽으로 1칸
    //배열의 위치가 A[dx[2]][dy[2]] = A[1][0] = 위로 1칸
    //배열의 위치가 A[dx[3]][dy[3]] = A[-1][0] = 아래로 1칸
    static Set<String> answer = new HashSet<>(); //6자리 숫자들 중복 없이 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //영역 초기화
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                numMap[i][j] = st.nextToken();
            }
        }

        //DFS 시작. 숫자판의 모든 위치(5x5)에서 한 번씩 실행해야 하므로 아래와 같이 반복
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //각각의 dfs는 [i][j]를 시작 위치로 해서 6자리 숫자를 만든다
                dfsWithStack(i, j);
            }
        }

        //Set에 저장된 값들의 갯수를 센다(중복 없이 저장되어 있음)
        bw.write(answer.size() + " ");
        bw.flush();
        bw.close();

    }


    //스택을 이용해서 DFS 구현
    private static void dfsWithStack(int startX, int startY) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY, 0}); //초기값 : {x, y, count}
        Stack<String> routeStack = new Stack<>();
        routeStack.push(numMap[startX][startY]); //초기값 : 경로

        //스택 하나로 풀어도 되지만 좀 더 명확하게 값들을 확인하려고 분리했다. 좌표 정보와 경로 정보로 분리.

        while (!stack.isEmpty()){
            //현재 상태 하나 꺼내오기
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            String route = routeStack.pop();

            //6자리 숫자가 완성되면 Set에 추가
            if(count==5){
                answer.add(route);
                continue;
            }
            //4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nowX = x + dx[i]; //이동 후의 새로운 좌표 x, y
                int nowY = y + dy[i];
                if (0 <= nowX && nowX < 5 && 0 <= nowY && nowY < 5) { //숫자판을 벗어나지 않도록 0~4 사이인지 검사. 같은 칸을 중복으로 밟아도 되므로 visited 체크하지 않음
                    stack.push(new int[]{nowX, nowY, count+1}); //스택에 변경되 좌표값, 숫자 하나 카운트
                    routeStack.push(route+numMap[nowX][nowY]); //경로 초기값에 현재 위치값도 더해준다(=> 이것때문에 count+1이 됨)
                }
            }
        }


    }
}
