package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class 숫자판점프2210 {

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
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 5; j++) {
                numMap[i][j] = st.nextToken();
            }
        }

        //DFS 시작. 숫자판의 모든 위치(5x5)에서 한 번씩 실행해야 하므로 아래와 같이 반복
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //각각의 dfs는 [i][j]를 시작 위치로 해서 6자리 숫자를 만든다
                dfs(i, j, numMap[i][j], 0);
            }
        }

        //Set에 저장된 값들의 갯수를 센다(중복 없이 저장되어 있음)
        bw.write(answer.size() + " ");
        bw.flush();
        bw.close();

    }

    //DFS 구현
    private static void dfs(int x, int y, String route, int count) {
        //재귀를 사용할 때는 종료 조건을 반드시 작성해야 한다
        if (count == 5) { //0부터 시작해서 5까지 카운트 되었을 때, 즉 숫자 6자리가 완성되면
            answer.add(route); //지금까지 만든 숫자(route)를 answer에 추가하고 종료함
            return;
        }

        //4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i]; //이동 후의 새로운 좌표 x, y
            int nowY = y + dy[i];
            if (0 <= nowX && nowX < 5 && 0 <= nowY && nowY < 5){ //숫자판을 벗어나지 않도록 0~4 사이인지 검사. 같은 칸을 중복으로 밟아도 되므로 visited 체크하지 않음
                dfs(nowX, nowY, route+numMap[nowX][nowY], count+1); //route + numMap[nowX][nowY]로 현재 숫자에 이동한 숫자르 추가하고, count+1로 길이를 늘려서 재귀호출
            }
        }


    }
}
