package hh99_1week.basic;

import java.io.*;
import java.util.Arrays;

public class solve10994 {
    public static void main(String[] args) throws IOException {
        /*
        * 문제 분석 :
        * - 예제를 보고 규칙을 유추한 뒤, 입력 받은 숫자에 맞게 별을 출력한다
        *
        * 풀이 전략 :
        * - 1. 숫자 n을 입력받는다.
        * - n이 1이면 *을 출력, 2면 *을 둘러싼 사각형, 3이면 2일때의 사각형을 둘러싼 사각형이 생긴다 -> 재귀 패턴
        * - n이 1일 때 : 1x1
        * - n이 2일 때 : 5x5
        * - n이 3일 때 : 9x9
        * - n이 증가할 때의 패턴 : 4*n-3 x 4*n-3
        * - 2. 4*n-3 x 4*n-3 크기의 배열을 만들고 값을 공백으로 초기화 한다
        * - 3. 바깥쪽 테두리를 *로 채운다
        * - 4. 재귀함수를 호출해서 안쪽에 더 작은 테두리를 채운다
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 숫자 n 입력받기
        int n = Integer.parseInt(br.readLine());

        // 2. 4*n-3 x 4*n-3 크기의 배열을 만들고 값을 공백으로 초기화 한다
        int size = 4*n-3;
        String[][] starArea = new String[size][size];

        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                starArea[i][j] = " ";
            }
        }

        //3. 바깥쪽 테두리를 *로 채운다
        drawStars(starArea, 0, size);

        //5. 출력
        for (int i=0;i<size;i++){
            // 5-1. String.join을 이용한 출력(성능 면에서 유리)
            bw.write(String.join("",starArea[i]));
            bw.newLine();
        }

        // 5-2. for-each문을 이용한 출력(직관적)
//        for (String[] starAreaArr : starArea) {
//            for (String star : starAreaArr) {
//                bw.write(star + "");
//            }
//            bw.newLine();
//        }

        bw.flush();
        bw.close();
    }

    public static void drawStars(String[][] starArea, int start, int size){
        //3. 바깥쪽 테두리를 *로 채운다
        //3-1. size가 1보다 작으면 그대로 리턴
        if(size < 1) return;

        int end = start + size - 1; //영역 마지막 숫자 계산

        //상하 테두리
        for(int i=start;i<end;i++){
            starArea[start][i] = "*";
            starArea[end][i] = "*";
        }

        // 좌우 테두리
        for (int i = start; i <= end; i++) {
            starArea[i][start] = "*"; // 좌측 테두리
            starArea[i][end] = "*";   // 우측 테두리
        }

        //4. 재귀함수를 호출해서 안쪽에 더 작은 테두리를 채운다
        drawStars(starArea, start+2, size-4);
    }
}
