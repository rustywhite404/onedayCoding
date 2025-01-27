package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BestGrass_6186 {
    static boolean[][] visited;
    static char[][] map;
    static int height;
    static int width;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 0; //목초지 덩어리 개수

        //모든 좌표를 확인하면서 BFS 실행
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == '#' && !visited[i][j]) {
                    bfs(i, j);
                    count++; //bfs를 실행 할 때 마다 덩어리 갯수 증가
                }
            }
        }
        bw.write(count + " ");
        bw.flush();
        bw.close();
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //맵 범위 안이고, 방문한 적 없으며, '#'인 경우 bfs 탐색
                if (nx >= 0 && ny >= 0 && nx < height && ny < width) {
                    if (!visited[nx][ny] && map[nx][ny] == '#') {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }


            }

        }
    }
}
