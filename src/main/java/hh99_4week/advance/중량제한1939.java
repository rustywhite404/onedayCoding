package hh99_4week.advance;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 입력 :
* - N개의 섬, M개의 다리
* - 중량 최소값1, 최대값은 입력받은 것 중에 가장 큰 중량
*
* 연산 :
* - 중량의 최대값과 최소값을 기준으로 이분 탐색
* - mid값을 기준으로 그래프 탐색. BFS로 현재 mid이상을 견딜 수 있는 경로가 존재하는지 확인
* - 존재하면 mid 증가, 아니면 감소
*
* */
public class 중량제한1939 {
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        int from, to, weight;
        int minWeight = 1; //중량 최소값
        int maxWeight = 0; //중량 최대값
        int result = 0; //결과값


        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            if(weight>maxWeight){
                maxWeight = weight;
            }
            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while (minWeight<=maxWeight) {
            visited = new boolean[N+1]; //방문 배열 초기화
            int mid = (minWeight+maxWeight)/2; //중간값(이분탐색용) 초기화
            if (bfs(mid, start, end)) {
                result = mid;
                minWeight = mid + 1;
            } else {
                maxWeight = mid - 1;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result+" ");
        bw.flush();
        bw.close();
    }

    private static boolean bfs(int mid, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); //시작지점, 중량
        visited[start] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            if(current==end){
                return true;
            }
            for (Edge e : graph[current]) {
                if(!visited[e.to] && e.weight>=mid){ //현재 다리의 중량 제한
                    visited[e.to] = true;
                    queue.add(e.to);
                }
            }

        }


        return false;
    }

    static class Edge{
        int to, weight; //연결된 노드, 중량 제한
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
