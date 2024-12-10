package hh99_4week.basic;

import java.io.*;
import java.util.*;

/*
 * 좌표 N과 K가 주어졌을 때의 최단경로를 구하는 문제.
 * 이동 범위는 X-1, X+1, 2*X.
 * 처음에 이렇게 풀었는데 나중에 다시 풀어보니 graph가 필요없었다.
 * 그리고 visited[cx]에서 방문처리 하는 것보다 visited[next]에서 방문처리 하는 방식이
 * 좀 더 bfs의 원리에 맞다.
 *
 * */
public class 숨바꼭질1697_re {
    static boolean[] visited = new boolean[100001];
    static int[] graph = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 1;
        for (int i = 1; i <= 100000; i++) {
            graph[i] = temp++;
        }

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
                if(dx[i]>=0 && dx[i]<=100000) {
                    int next = graph[dx[i]];
                    if (!visited[next]) {
                        queue.add(new int[]{next, cd + 1});
                    }
                }
            }
        }

        return -1;
    }
}