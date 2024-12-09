package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class 특정거리의도시찾기18352 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int node, edge, distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 초기화
        visited = new boolean[node+1];
        graph = new ArrayList[node+1];

        //graph 초기화
        for(int i=1;i<=node;i++){
            graph[i] = new ArrayList<>();
        }
        //graph에 값 넣기
        for(int i=1;i<=edge;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); //단방향이므로 이렇게만 입력
        }

        //bfs 구현
        bfs(start, distance);

    }

    private static void bfs(int start, int distance) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<int[]> queue = new LinkedList<>();
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        queue.add(new int[]{start,depth}); //시작번호, depth
        while (!queue.isEmpty()){
            int current[] = queue.poll();
            int currentStart = current[0];

            if(!visited[currentStart]){
                visited[currentStart] = true;
                int currentDepth = current[1];
                if(currentDepth==distance){
                    list.add(currentStart);
                }
                for(int i=0;i<graph[currentStart].size();i++){
                    int next = graph[currentStart].get(i);
                    if(!visited[next]){
                        int nextDepth = currentDepth+1;
                        queue.add(new int[]{next, nextDepth});
                    }
                }
            }
        }
        if(list.isEmpty()){
            bw.write("-1");
        }else{
            Collections.sort(list);
            for (Integer i : list) {
                bw.write(i+" ");
                bw.newLine();

            }
        }
        bw.flush();
        bw.close();

    }
}
