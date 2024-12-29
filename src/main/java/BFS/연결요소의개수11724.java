package BFS;

import java.io.*;
import java.util.*;

public class 연결요소의개수11724 {
    /*
    * - 첫줄에 정점 개수 N, 간선의 개수 M
    * - 무방향 그래프이므로 서로에게 다 넣어줘야 함
    * -
    * */
    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        //간선 입력
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x); //무방향 그래프니까 양쪽으로 넣어준다
        }

        visited = new boolean[n+1];
        int count = 0;

        //모든 정점을 순회하며 BFS를 호출하고, 방문하지 않은 정점이라면 카운트를 추가
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int i : graph.get(current)) {
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
