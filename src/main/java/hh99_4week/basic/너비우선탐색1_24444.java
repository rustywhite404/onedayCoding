package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class 너비우선탐색1_24444 {

    //정점, 간선, 시작점이 필요하다
    static int node, edge, start;
    //방문정보 배열, 인접그래프 배열, 방문순서 배열이 필요하다
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] order;
    //방문 횟수도 카운트가 필요하다
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        //방문정보, 인접그래프 배열, 방문순서 배열 크기를 지정한다
        visited = new boolean[node + 1];
        graph = new ArrayList[node + 1];
        order = new int[node + 1];

        //인접그래프 배열 안에 들어갈 배열들을 초기화 한다
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        //인접그래프에 값을 입력받는다.
        for (int i = 1; i <= edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); //양방향 입력
        }

        //리스트를 오름차순으로 초기화 한다
        for (int i=1;i<=node;i++) {
            Collections.sort(graph[i]);
        }

        //bfs 구현
        bfs(start);

        //결과 출력
        for(int i=1;i<=node;i++){
            bw.write(order[i]+" ");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        //bfs구현

        //큐를 만들고 값을 하나 넣는다
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        //큐가 빌 때까지 반복
        while (!queue.isEmpty()){
            //큐에서 값을 하나 꺼낸다
            int current = queue.poll();

            //꺼낸 값이 아직 방문한 적 없을 때에만 이하를 실행
            if(!visited[current]) {
                //꺼낸 값을 방문처리
                visited[current] = true;
                //방문순서 배열의 꺼낸값 자리에 기존순서+1;
                order[current] = count++;

                //꺼낸 값의 인접 노드들을 탐색한다
                for(int i=0;i<graph[current].size();i++){
                    //인접그래프의 꺼낸값 안에 들어있는 인접값들 중 첫번째 값 꺼냄 => 다음순번
                    int next = graph[current].get(i);
                    //다음 순번값이 아직 방문된 적 없는 값이면 큐에 넣기 => 재방문이면 무시
                    if(!visited[next]){
                        queue.add(next);
                    }
                }

            }
        }

    }
}
