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
public class 촌수계산2644_큐분리 {
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
        Queue<Integer> nodeQueue = new LinkedList<>(); // 탐색할 노드
        Queue<Integer> depthQueue = new LinkedList<>(); // 각 노드의 촌수

        nodeQueue.add(start); // 시작 노드 추가
        depthQueue.add(0);    // 시작 노드의 촌수는 0

        while (!nodeQueue.isEmpty()) {
            int current = nodeQueue.poll();
            int depth = depthQueue.poll(); // 현재 노드의 촌수

            if (current == end) { // 목표 노드에 도달하면 촌수를 반환
                return depth;
            }

            if (!visited[current]) {
                visited[current] = true;

                for (int next : graph[current]) {
                    if (!visited[next]) {
                        nodeQueue.add(next);        // 다음 노드 추가
                        depthQueue.add(depth + 1); // 촌수 +1
                    }
                }
            }
        }

        return -1; // 목표 노드에 도달하지 못한 경우
    }
}
