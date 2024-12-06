package hh99_4week.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프왕쩰리16173_re {
    /*
     * boolean[][] 사용해서, 반복문을 돌리되 한 번 찍은 건 다시 사용하지 않도록 처리해서 푸는 방법.
     * 정사각형 내부에서만 점프가 가능. 출발점은 항상 0,0
     * 이동은 오른쪽과 아래로만 가능.
     * 값이 -1인 행렬에 도착하면 승리.
     * 승리시 HaruHaru 출력, 실패시 Hing
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int depth = Integer.parseInt(br.readLine());
        int[][] area = new int[depth][depth];

        //배열 초기화
        for (int i = 0; i < depth; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < depth; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //방문한 자리 저장
        boolean[][] visited = new boolean[depth][depth];
        visited[0][0] = true; //시작점 변경
        boolean flag = false;

        for (int i = 0; i < depth && !flag; i++) {
            for (int j = 0; j < depth && !flag; j++) {
                int current = area[i][j];

                //배열의 값이 0이면 continue;
                if (current == 0 || !visited[i][j]) {
                    continue;
                }
                if (current == -1) {
                    flag = true; //목표 도달
                    break;
                }
                if (j + current < depth && !visited[i][j + current]) { //영역 안쪽이거나 아직 밟지 않은 곳이면
                    visited[i][j + current] = true;
                }
                if (i + current < depth && !visited[i + current][j]) {
                    visited[i + current][j] = true;
                }
            }
        }
        System.out.println(flag ? "HaruHaru" : "Hing");

    }
}
