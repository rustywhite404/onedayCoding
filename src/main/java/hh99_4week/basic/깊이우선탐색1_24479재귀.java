package hh99_4week.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class 깊이우선탐색1_24479재귀 {
    static int node; //정점
    static int edge; //간선
    static int start; //시작점
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] order ;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        //그래프, 방문 배열 크기 초기화
        visited = new boolean[node + 1];
        graph = new ArrayList[node + 1];
        order = new int[node+1];

        //배열 생성
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        //값 입력받기
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); //양방향 배열로 만들어줌
        }

        //리스트 오름차순으로 초기화
        for (int i = 1; i <= node; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start);

        // 결과 출력
        for (int i = 1; i <= node; i++) {
            System.out.println(order[i]); //order에 추가된 순서
        }

    }

    //DFS로 탐색 - 재귀 사용
    private static void dfs(int start) {
        visited[start] = true; //방문처리
        order[start] = count++; //방문순서 추가
        for (int i = 0; i< graph[start].size();i++) {
            int next = graph[start].get(i);
            if (!visited[next]) { //아직 방문한 적 없으면 스택에 넣기
                dfs(next);
            }
        }


    }
}
