package hh99_4week.basic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프왕쩰리16173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int depth = Integer.parseInt(br.readLine()); //영역의 너비
        int[][] area = new int[depth][depth];

        //영역 초기화
        for (int i = 0; i < depth; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < depth; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //BFS로 탐색
        if (bfs(area, depth)) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }
        bw.flush();
        bw.close();

    }

    private static boolean bfs(int[][] area, int depth) {
        //방향 : 오른쪽, 아래쪽
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] visited = new boolean[depth][depth]; //이미 방문한 자리
        Queue<int[]> queue = new LinkedList<>();

        //시작점 추가
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) { //큐에 값이 있는 동안 계속됨
            int[] current = queue.poll(); //큐의 맨 앞에 있는 값이 현재값
            int x = current[0]; //current{x,y}에서 꺼냄
            int y = current[1];

            //목표에 도달하면 즉시 반환
            if (area[x][y] == -1) {
                return true;
            }

            //이동 가능한 거리
            int jump = area[x][y];

            for (int i = 0; i < 2; i++) { //배열의 크기가 2이므로 0, 1까지의 범위에서
                //이동할 위치 계산
                //현재 위치가 (x, y)이고 오른쪽으로 1칸 점프한다면
                //새로운 위치 : (x+0*1, y+1*1) = (x, y+1)
                int nx = x + dx[i] * jump; //x축 이동량
                int ny = y + dy[i] * jump; //y축 이동량

                //유효 범위 체크, 방문 여부 확인
                if (nx >= 0 && ny >= 0 && nx < depth && ny < depth && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

            }

        }
        return false;
    }

}
