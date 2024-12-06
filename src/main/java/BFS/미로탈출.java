package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출 {
    /*
    * - 2차원 배열(미로)에서 (0,0)에서 시작해서 (N-1, M-1)까지이동
    * - 0은 통로, 1은 벽. 벽은 지나갈 수 없고 통로만 지나갈 수 있다.
    * 테스트값 :
    5 6
    110110
    110110
    111110
    011111
    011111
    * 기대값 : 9
    * */
    static boolean[][] visited;
    static int[][] map;
    static int count;
    static int dx[] = new int[]{0, 0, 1, -1};
    static int dy[] = new int[]{1, -1, 0, 0};
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        visited = new boolean[h][w];
        map = new int[h][w];
        //map 초기화
        for (int i = 0; i < h; i++) {
            String list = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = list.charAt(j) - '0';
            }
        }
        // BFS 호출
        int result = bfs(0, 0);


        bw.write("걸음수 : " + result);
        bw.flush();
        bw.close();
    }

    private static int bfs(int x, int y) {
        //큐를 만든다
        Queue<int[]> queue = new LinkedList<>();
        //큐에 하나를 넣는다
        queue.add(new int[]{x, y});
        //넣은 값 방문처리
        visited[x][y] = true;

        int step = 0;
        //큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int size = queue.size(); //현재 지점의 노드 개수

            //현재 레벨의 모든 노드 처리
            for (int i = 0; i < size; i++) {
                //큐에서 하나를 뺀다
                int[] current = queue.poll();
                int cx = current[0];
                int cy = current[1];

                if (cx == h - 1 && cy == w - 1) return step; //도착지에 오면 반환
                //뺀 값의 자식 노드들을 탐색
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];
                    if (nx >= 0 && ny < w && ny >= 0 && nx < h && !visited[nx][ny] && map[nx][ny] != 0) {
                        //범위 안이고, 아직 방문하지 않았고, 값이 1이 아니면 방문처리하고 스택에 넣기
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            step++;
        }
        return -1; //도착 할 수 없는 경우
    }
}
