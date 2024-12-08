package hh99_4week.advance;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 10x10의 영역이 있다.
 * B라는 글자는 방금 불이 난 지역이다.
 * L은 호수, R은 큰 바위의 위치이다.
 * 양동이는 4방향으로 이동이 가능하다.
 * 큰 바위가 있는 사각형에는 소를 놓을 수 없다.
 * L에서 B까지 가는 최단거리를 구해라.
 * => BFS로 구하기
 * */
public class BucketBrigade {
    static boolean[][] visited = new boolean[10][10];
    static char[][] map = new char[10][10];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] start;
    static int[] end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //영역 채우기
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char word = line.charAt(j);
                map[i][j] = word;
                if (word == 'L') {
                    start = new int[]{i, j};
                }
            }
        }

        System.out.println(bfs(start));
    }

    private static int bfs(int[] start) {
        //큐를 만들고 하나를 넣는다
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], -1}); //-1은 시작 거리. 소가 시작지점에 들어가면 0이 됨
        visited[start[0]][start[1]] = true;

        //큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            //큐에서 하나를 뺀다
            int current[] = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int distance = current[2];

            if (map[cx][cy] == 'B') { //end와 같다면 현재까지의 거리 반환
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                //선택한 값의 인접 노드들(상하좌우)이 이전에 방문한 적 없으면서, 영역 안의 값이고, R이 아닌지 확인
                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && !visited[nx][ny] && map[nx][ny] != 'R') {
                    visited[nx][ny] = true;
                    //end가 아니라면 큐에 넣기
                    queue.add(new int[]{nx, ny, distance+1});

                }

            }


        }

        return -1; //도착하지 못하면 -1
    }
}
