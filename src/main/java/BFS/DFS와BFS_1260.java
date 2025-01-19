package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class DFS와BFS_1260 {
    static int node;
    static int edge;
    static int start;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        //작은 번호부터 방문하기 위해 정렬
        for(int i=1;i<=node;i++){
            Collections.sort(graph[i]);
        }
        visited = new boolean[node + 1];
        dfs(start);
        System.out.println();

        visited = new boolean[node + 1];
        bfs(start);

    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
                for (int i = graph[current].size() - 1; i >= 0; i--) {
                    int next = graph[current].get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (Integer i : graph[current]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }


    }
}
