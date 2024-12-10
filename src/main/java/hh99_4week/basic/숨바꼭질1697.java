package hh99_4week.basic;

import java.io.*;
import java.util.*;

/*
 * 좌표 N과 K가 주어졌을 때의 최단경로를 구하는 문제.
 * 이동 범위는 X-1, X+1, 2*X.
 * */
public class 숨바꼭질1697 {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bw.write(bfs(start, end) + " ");
        bw.flush();
        bw.close();
    }

    private static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        int depth = 0;
        queue.add(new int[]{start, depth});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int cx = current[0];
            int cd = current[1];
            int dx[] = new int[]{cx - 1, cx + 1, cx * 2};
            if (cx == end) {
                return cd;
            }
            for (int i = 0; i < 3; i++) {
                if (!visited[cx]) {
                    visited[cx] = true;
                }
                int next = dx[i];
                if(next>=0 && next<=100000 && !visited[next]) {
                        queue.add(new int[]{next, cd + 1});

                }
            }
        }

        return -1;
    }
}
