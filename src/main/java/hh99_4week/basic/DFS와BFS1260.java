package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class DFS와BFS1260 {
    static int node;
    static int edge;
    static int start;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken()); //정점 수
        edge = Integer.parseInt(st.nextToken()); //간선 수
        start = Integer.parseInt(st.nextToken()); //시작번호

        graph = new ArrayList[node+1]; //행렬

        //배열 생성
        for(int i=1;i<=node;i++){
            graph[i] = new ArrayList<>();
        }

        //입력받기
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); //양방향 배열로 만들어줌
            graph[b].add(a);
        }

        //작은 번호부터 방문하기 위해 정렬
        for(int i=1;i<=node;i++){
            Collections.sort(graph[i]);
        }

        //DFS 실행
        visited = new boolean[node+1];
        dfs(start);
        System.out.println();

        //BFS 실행(visited 초기화)
        visited = new boolean[node+1];
        bfs(start);

    }

    private static void dfs(int start) {
        //스택을 만든다
        Stack<Integer> stack = new Stack<>();
        //스택에 첫번째 값을 넣는다
        stack.push(start);

        //스택이 빌 때까지 실행
        while (!stack.isEmpty()){
            //스택에서 하나 꺼낸다
            int current = stack.pop();

            if(!visited[current]){
                //넣은 값을 방문 처리
                visited[current]= true;
                //출력
                System.out.print(current+" ");
                //영역 탐색 후 스택에 값들을 집어넣는다
                for (int i = graph[current].size() - 1; i >= 0; i--) {  // 역순으로 넣어야 작은 번호부터 탐색
                    int next = graph[current].get(i);
                    if(!visited[next]){
                        stack.push(next);
                    }
                }
            }
        }


    }

    private static void bfs(int start) {
        //큐를 만든다
        Queue<Integer> queue = new LinkedList<>();
        //큐에 첫번째 값을 넣는다
        queue.add(start);
        //넣은 값은 방문 처리
        visited[start] = true;

        //큐가 빌때까지 실행
        while (!queue.isEmpty()){
            //큐에서 하나를 뺀다
            int current = queue.poll();
            System.out.print(current+" "); //출력

            //영역 탐색 후 큐에 자식들을 집어넣는다
            for (Integer i : graph[current]) {
                if(!visited[i]){ //아직 방문한 적 없다면 큐에 넣고(작은 수부터 들어감) 방문 처리
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }


    }
}
