package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NewTime26876_bfs {
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(":"), b = br.readLine().split(":");
        int s = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]); //잘못된 시간을 분 단위로 변환
        int e = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]); //옳은 시간을 분 단위로 변환
        if (s > e) {
            //잘못된 시간이 더 크면 하루를 더해서 시간 차이를 양수로 만든다
            // ex. 19:44에서 08:50으로 가야한다면 530-1184=-654인데, 여기에서 1440을 더해 786으로 변환
            e += 60 * 24;
        }
        n = e - s; //잘못된 시간에서 올바른 시간으로 가기 위해 필요한 총 분 차이
        visited = new boolean[n + 1]; //방문 여부를 분 단위로 기록

        System.out.println(bfs());
    }

    //최소 버튼 횟수 구하기
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        //1. 시작점을 큐에 넣는다
        queue.add(new int[]{0, 0}); //현재 상태 : 경과 시간, 버튼 누른 횟수
        visited[0] = true;
        int[] dx = {1, 60}; //버튼A : +1분, 버튼B : +60분

        //2. 큐에서 하나 꺼낸다
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == n) {
                //now[0]이 현재 경과 시간, now[1]이 버튼 횟수인데
                //now[0](경과시간)이 n과 같으면 목표에 도달한 것이므로 버튼 누른 횟수 (now[1])를 반환한다.
                return now[1];
            }

            //꺼낸 값에서 갈 수 있는 모든 위치를 계산한다
            for (int i = 0; i < 2; i++) {
                int nx = now[0] + dx[i]; //현재 상태 + 버튼 효과를 더한 다음 상태
                if(nx <= n && !visited[nx]){ //다음 상태가 목표를 초과하지 않음 && 이전에 방문하지 않은 상태
                    queue.add(new int[]{nx, now[1]+1});
                    visited[nx] = true; //조건을 만족하면 큐에 추가하고, 해당 상태를 방문 처리
                }
            }

        }

        return -1; //문제 조건상 발생하지 않음
    }
}
