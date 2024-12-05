package dataStructure;

import java.util.*;

public class BFS {

    /*
    * 입력 예제 :
        5 6 1
        1 2
        1 3
        2 4
        2 5
        3 5
        4 5
    * */
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

        //BFS탐색
        bfs(start, graph, n);

    }

    private static void bfs(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1]; //노드 번호가 1번부터 시작하므로 노드 번호와 배열 인덱스를 매칭, visited[0]은 사용하지 않음
        queue.add(start);
        visited[start] = true;
        System.out.println("--------BFS 탐색순서:");
        while (!queue.isEmpty()){
            int node = queue.poll(); //큐에서 노드 꺼냄
            System.out.println("출력: "+node);

            //인접 노드 탐색
            //ex.
            //1 -> [2, 3]
            //2 -> [1, 4, 5]
            //3 -> [1, 5]
            //4 -> [2, 5]
            //5 -> [2, 3, 4]
            for(int neighbor : graph.get(node)){ //2번 노드의 인접 노드는 1, 4, 5
                if(!visited[neighbor]){ //아직 방문된 적 없는 노드면
                    queue.add(neighbor); //큐에 추가
                    visited[neighbor] = true; //방문 처리
                }
            }
        }
    }
}
