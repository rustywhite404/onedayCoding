package 정렬;

import java.io.*;
import java.util.*;

public class 좌표정렬하기11650 {
    /*
    * 입력 :
    * - 점의 개수 N
    * - N번 동안 i번 점의 위치 Xi, Yi 가 주어짐
    *
    * 출력 : X값이 큰 순으로, X가 같을 경우 Y값이 큰 순으로 정렬
    *
    * 전략 : Priority Queue나 List sort를 쓰되 정렬 조건을 커스텀
    * */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        List<int[]> points = new ArrayList<>();
        for(int i=0;i<total;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new int[]{x,y});
        }

        //x값이 작은 순으로, 같다면 y값이 작은 순으로 정렬
        points.sort((p1,p2)->{
            if(p1[0] != p2[0]){
                return Integer.compare(p1[0],p2[0]);
            }else {
                return Integer.compare(p1[1],p2[1]);
            }
        });


        for (int[] point : points) {
            bw.write(point[0]+" "+point[1]);
            bw.newLine();
        }
        bw.flush();

    }
}
