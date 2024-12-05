package hh99_4week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class BestGrass6186 {
    /*
    * 처음에는 큐에 넣어서 하나씩 빼면서 인접한 값을 체크하려고 했는데
    * 줄바꿈이나 아래로 연속된 #을 처리할 수 없다는 걸 깨달음.
    * 행렬에 값을 넣고 오른쪽, 아래쪽 값과 비교해서 카운트 한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()); //행
        int h = Integer.parseInt(st.nextToken()); //열
        Character[][] list = new Character[w][h];
        //행렬에 넣기
        for (int i = 0; i < w; i++) {
            String line = br.readLine();
            for (int j = 0; j < h; j++) {
                list[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (list[i][j].equals('.')) {
                    continue;
                } else if (list[i][j].equals('#')) { //값이 #이면
                    if (j < h - 1 && list[i][j + 1].equals('#')) { //옆에 있는 값도 #인지 확인, 맞다면 한 덩어리이므로 일단 계속함
                        continue;
                    }
                    if (i < w - 1 && list[i + 1][j].equals('#')) { //아래에 있는 값도 #인지 확인, 맞다면 한 덩어리이므로 일단 계속함
                        continue;
                    }
                    ;
                    //옆이나 아래에 같은 덩어리가 계속되지 않는다면 덩어리가 끝났으므로 카운트
                    count++;
                }
            }
        }

        bw.write(count + " ");
        bw.close();

    }
}
