package hh99_4week.basic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 나이트는 L자로 이동할 수 있다.
* 가능한 이동 경로 :
(x - 2, y - 1)
(x - 2, y + 1)
(x + 2, y - 1)
(x + 2, y + 1)
(x - 1, y - 2)
(x - 1, y + 2)
(x + 1, y - 2)
(x + 1, y + 2)
=> 좌표를 참고해서 BFS로 풀이
* *
* */
public class 나이트의이동7562 {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = new int[]{-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dy = new int[]{-1, +1, -1, +1, -2, 2, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            int width = Integer.parseInt(br.readLine());
            graph = new int[width][width];
            visited = new boolean[width][width];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int step = 0;
            bw.write(bfs(startX, startY, endX, endY, width) + " ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int bfs(int startX, int startY, int endX, int endY, int width) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true; //시작지점 방문

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int step = current[2];
            if (cx == endX && cy == endY) {
                return step;
            }
            //현재 좌표가 범위 안이고, 이전에 방문한 적 없으면 visited처리

            for (int i = 0; i < 8; i++) { //L방향으로 움직일 수 있는 경우의 수 만큼 확인
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < width && ny >= 0 && ny < width && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, step + 1});
                }
            }

        }
        return -1;
    }
}
