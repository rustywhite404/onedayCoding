package hh99_1week.basic;

import java.io.*;

public class solve2445 {
    public static void main(String[] args) throws IOException {
        // 1. 숫자를 입력받고, 출력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        // 2. 배열의 길이는 [2*num-1][2*num]인 것 같다(별찍기는 2xn-1번 반복된다).
        String[][] stars = new String[2*num-1][2*num];
        // 3. 배열을 공백으로 초기화
        for(int i=0;i<2*num-1;i++){
            for(int j=0;j<2*num;j++){
                stars[i][j] = " ";
            }
        }

        //[0][0]
        //[1][0], [1][1]
        //[2][0], [2][1], [2],[2]...
        int currentNum = 1;
        // 4-1. 배열에 별 찍기(위쪽 반)
        for(int i=0;i<num;i++){
          for(int j=0;j<currentNum;j++){
              stars[i][j] = "*";
          }
          currentNum++;
        }

        // 여기까지 하다가 너무 복잡하게 돌아가고 있는 것 같아서 풀이 방법을 바꾸기로 함
        // for문만 사용해서 찍어보기로 했다

        bw.flush();
        bw.close();
    }
}
