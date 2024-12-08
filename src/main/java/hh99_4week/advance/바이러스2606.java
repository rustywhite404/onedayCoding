package hh99_4week.advance;

import java.io.*;
import java.util.*;

public class 바이러스2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] order;
    static int node; //컴퓨터의 수
    static int edge;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[node + 1];
        graph = new ArrayList[node + 1];
        order = new int[node+1];
        count = 0;
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        //리스트 오름차순으로 초기화
        for (int i = 1; i <= node; i++) {
            Collections.sort(graph[i]);
        }

        bfs(1);
        int result = 0;
        for (boolean b : visited) {
            if(b){
                result++;
            }
        }
        System.out.println(result-1); //1번 컴퓨터 제외

    }

    private static void bfs(int start) {
        //큐를 만든다
        Queue<Integer> queue = new LinkedList<>();
        //큐에 값을 하나 넣는다
        queue.add(start);
        //큐가 빌 때까지 계속
        while (!queue.isEmpty()) {
            //큐에서 값을 뺀다
            int current = queue.poll();
            //뺀 값이 방문한 적 없으면
            if (!visited[current]) {
                //방문 처리
                visited[current] = true;
                //큐에서 뺀 값의 다음 값을 확인
                for (int i = 0; i < graph[current].size(); i++) {
                    int next = graph[current].get(i);
                    if(!visited[next]){
                        queue.add(next);
                    }
                }
                //다음 값이 방문한 적 없으면 큐에 넣기
            }

        }

    }
}
