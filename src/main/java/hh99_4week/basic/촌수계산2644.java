package hh99_4week.basic;

import java.io.*;
import java.util.*;

/*
 * 입력 :
 * - 전체 사람 수(Node)
 * - 둘쨋줄부터 계산해야 하는 번호 A, B
 * - 간선의 수 M(edge)
 * - 부모 자식간의 관계 x, y
 *
 * 연산 :
 * - 인접 그래프를 만들고, 내가 원하는 시작점에서 도착점으로 가는 최단거리를 구한다
 * - BFS로 구하기
 * - 끝까지 돌았는데도 만나지 못하면 -1
 *
 * 출력 :
 * - A와 B의 촌수를 구하고, 전혀 촌수가 없으면 -1
 * */
public class 촌수계산2644 {
    static int node;
    static int start, end;
    static int edge;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        node = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        edge = Integer.parseInt(br.readLine());

        visited = new boolean[node + 1];
        graph = new ArrayList[node + 1];

        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(graph[i]);
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bw.write(bfs(start, end) + " ");
        bw.flush();
        bw.close();

    }

    private static int bfs(int start, int end) {
        //큐를 하나 만든다. 시작지점과 촌수 배열 추가
        Queue<int[]> queue = new LinkedList<>();
        //큐 안에 입력
        queue.add(new int[]{start, 0}); //0촌부터 시작
        //큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            //큐에서 하나 꺼낸다
            int current[] = queue.poll();
            int currentNode = current[0];
            int depth = current[1];

            //꺼낸 값이 목표값이면 현재까지의 count를 반환한다
            if (currentNode == end) {
                return depth;
            }
            //꺼낸 값이 아직 방문한 적 없고, 목표값이 아닐 때 분기 실행
            if (!visited[currentNode]) {
                //방문 처리
                visited[currentNode] = true;
                //꺼낸 값의 인접 노드들을 탐색한다
                for (int i = 0; i <= graph[currentNode].size() - 1; i++) {
                    //인접 그래프의 꺼낸 값 안에 들어있는 인접 값들 중 i번째 값 꺼냄 => 다음 순번으로 씀
                    int next = graph[currentNode].get(i);
                    //다음 순번이 아직 방문된 적 없는 값이면 큐에 넣기
                    if (!visited[next]) {
                        queue.add(new int[]{next, depth + 1});
                    }
                }
            }
        }
        //큐가 끝나도 관계가 없으면 -1 출력
        return -1;
    }
}
