package hh99_4week.basic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 10x10의 영역이 있다.
 * B라는 글자는 방금 불이 난 지역이다.
 * L은 호수, R은 큰 바위의 위치이다.
 * 양동이는 4방향으로 이동이 가능하다.
 * 큰 바위가 있는 사각형에는 소를 놓을 수 없다.
 * L에서 B까지 가는 최단거리를 구해라.
 * => BFS로 구하기
 * */
public class BucketBrigade17198 {
    static boolean[][] visited = new boolean[10][10];
    static char[][] map = new char[10][10];
    static int[] start;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char node = line.charAt(j);
                map[i][j] = node;
                if (node == 'L') {
                    start = new int[]{i, j};
                }
            }
        }
        bw.write(bfs(start) + " ");
        bw.flush();
        bw.close();
    }

    private static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], -1}); //소들의 이동 위치 -1부터 시작.(소들이 시작점(0)까지 와야 시작점에서부터 카운트가 가능하므로)
        visited[start[0]][start[1]]= true;
        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int step = current[2];
            if (map[cx][cy] == 'B') {
                return step;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && !visited[nx][ny] && map[nx][ny] != 'R') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, step + 1});
                }
            }

        }
        return -1;
    }
}
