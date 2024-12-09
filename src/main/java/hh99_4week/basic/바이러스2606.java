package hh99_4week.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 1번 컴퓨터와 연결되어 있는 컴퓨터의 수(본인 제외)를 구하는 문제이다.
* BFS를 이용
*
* */
public class 바이러스2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int node, edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        graph = new ArrayList[node+1];

        visited = new boolean[node+1];
        for (int i=0;i<node+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); //양방향 간선
        }

        bfs(1);
        int result = 0;
        for (boolean b : visited) {
            if(b){
                result++;
            }
        }
        bw.write(result-1+" ");
        bw.newLine();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(!visited[current]){
                visited[current] = true;
                for(int i=0;i<graph[current].size();i++){
                    int next = graph[current].get(i);
                    if(!visited[next]){
                        queue.add(next);
                    }
                }
            }
        }
    }
}
