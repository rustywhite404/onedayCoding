package hh99_4week.basic;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 테스트 케이스 개수 T
 * 영역의 가로길이 M 세로길이 N 배추의 위치개수 K
 * K개만큼 배추의 좌표값(X,Y)
 * - 0인 영역은 세지 않고, 1인 영역이 몇 덩어리나 있는지 계산
 * */
public class 유기농배추1012 {

    static boolean[][] visited;
    static int[][] map;
    static int dx[] = new int[]{1, -1, 0, 0};
    static int dy[] = new int[]{0, 0, 1, -1};
    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int area = Integer.parseInt(st.nextToken());
            int wormCount = 0;
            visited = new boolean[width][height];
            map = new int[width][height];

            //배추 심기
            for (int j = 0; j < area; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            //이제 전체 맵을 돌면서, 아직 방문한 자리가 아니면서 0도 아닌 칸을 찾아서 거기서부터 상하좌우 탐색을 시작한다.
            for (int w = 0; w < width; w++) {
                for (int h = 0; h < height; h++) {
                    if (!visited[w][h] && map[w][h] != 0) {
                        dfs(w, h);
                        wormCount++;
                    }
                }
            }
            bw.write(wormCount + " ");
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static void dfs(int startX, int startY) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!stack.isEmpty()) {
            int currrent[] = stack.pop();
            int cx = currrent[0];
            int cy = currrent[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < width && ny >= 0 && ny < height && !visited[nx][ny] && map[nx][ny]!=0) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }
}
