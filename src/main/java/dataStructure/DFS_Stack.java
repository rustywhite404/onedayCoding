package dataStructure;

import java.util.*;

public class DFS_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력처리
        int n = sc.nextInt(); //노드 개수
        int m = sc.nextInt(); //간선 개수
        int start = sc.nextInt(); //시작 노드
        List<List<Integer>> graph = new ArrayList<>();

        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //간선 입력
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); //무방향 그래프. 이게 없으면 방향이 있는 그래프가 됨
        }

        //인접 리스트 정렬(선택사항, 필수아님)
        //가독성 향상, 문제에서 정렬을 요구하는 경우가 많기 때문에 정렬했지만
        //그래프가 크고 정렬이 비효율적인 경우나 탐색 순서가 중요하지 않다면 안해도 OK
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i)); //오름차순 정렬
        }

        //스택을 사용한 DFS 탐색
        dfsUsingStack(start, graph, n);
    }

    private static void dfsUsingStack(int start, List<List<Integer>> graph, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1]; //방문여부

        stack.push(start); //시작 노드 삽입
        System.out.println("----------DFS 탐색 순서(스택 사용)");
        while (!stack.isEmpty()) {
            int node = stack.pop(); //스택에서 노드 꺼냄

            //방문하지 않은 노드만 처리
            if (!visited[node]) {
                visited[node] = true; //방문처리
                System.out.println("탐색: " + node);

                //인접 노드를 역순으로 스택에 추가(오름차순 탐색 유지) => 오름차순 탐색 유지는 옵션(필수x)
                List<Integer> neighbors = graph.get(node);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }

    }
}
