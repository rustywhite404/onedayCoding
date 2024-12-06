package hh99_4week.basic;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 양치기꿍3187 {
    /*
     * 입력 :
     * - 첫줄에 영역의 크기 R, C가 주어진다
     * - R줄에 C개의 문자가 주어진다. '.'은 빈공간, '#'는 울타리, 'v'는 늑대, 'k'는 양이다.
     * - 영역 안에서 양K의 수가 늑대V보다 많다면 양만 살아남는다
     * - 영역 안에서 늑대V의 수가 양K보다 많다면 해당 영역의 양이 모두 잡아먹힌다.
     *
     * 연산 :
     * - 너비 전체를 탐색하니까 DFS로 풀면 좋을 것 같다.
     * - 일단 이차원배열 형태의 맵을 만든다.
     * - 특정 위치에서 시작해서 연결된 모든 .를 탐색하고, 영역 내의 k와 v를 센다
     * - 탐색 종료 후 k와 v를 비교해서 결과에 반영한다
     * - 전체 맵을 순회하면서 아직 방문한 적 없는 .에서 탐색 시작
     *
     * 출력 :
     * 살아남은 양k과 늑대v의 수를 각각 순서대로 츨력한다.
     * */

    static int R, C; //영역의 크기
    static char[][] map; //영역을 표현할 이차원배열
    static boolean[][] visited; //이미 방문한 영역 표시
    static int sheepCount = 0, wolfCount = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C]; //입력받은 크기로 맵 초기화
        visited = new boolean[R][C]; //방문한 자리도 초기화

        //맵에 값들 넣기
        for (int i = 0; i < R; i++) {
            String word = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = word.charAt(j);
            }
        }

        //이제 전체 맵을 돌면서, 아직 방문한 자리가 아니면서 #도 아닌 칸을 찾아서 거기서부터 상하좌우 탐색을 시작한다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    dfs(i, j);
                }
            }
        }
        bw.write(sheepCount + " " + wolfCount);
        bw.flush();
        bw.close();

    }

    //스택을 사용한 DFS
    private static void dfs(int x, int y) {
        //스택을 만들고 하나 넣는다
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        int sheep = 0, wolf = 0;

        while (!stack.isEmpty()) { //스택이 빌 때까지 반복
            int[] current = stack.pop(); //스택에서 하나 꺼냄
            int cx = current[0]; //현재 x값
            int cy = current[1]; //현재 y값

            if (map[cx][cy] == 'k') sheep++;
            if (map[cx][cy] == 'v') wolf++;

            //k나 v가 아니면 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        if(sheep>wolf){
            sheepCount += sheep;
        }else{
            wolfCount += wolf;
        }

    }
}
