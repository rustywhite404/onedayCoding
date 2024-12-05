package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력처리
        int n = sc.nextInt(); //노드 개수
        int m = sc.nextInt(); //간선 개수
        int start = sc.nextInt(); //시작 노드
        List<List<Integer>> graph = new ArrayList<>();

        //그래프 초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        //간선 입력
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); //무방향 그래프. 이게 없으면 방향이 있는 그래프가 됨
        }

        //DFS 탐색
        boolean[] visited = new boolean[n+1]; //노드와 배열의 값 매칭시켜주가. visited[0]은 사용하지 않음
        System.out.println("--------DFS 탐색순서:");
        dfs(start, graph, visited);
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true; //현재 노드 방문처리
        System.out.println("출력 : "+node); //방문 후 출력

        //인접 노드 탐색
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, graph, visited); //재귀호출
            }
        }
    }
}
