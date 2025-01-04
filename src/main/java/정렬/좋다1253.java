package 정렬;

import java.io.*;
import java.util.*;

public class 좋다1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] numList = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < total; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numList);

        int goodNum = 0;
        for(int i=0;i<total;i++){
            int currentNum = numList[i]; //이번에 비교할 숫자
            int first = 0; //배열의 첫번째 자리
            int last = total-1; //배열의 마지막 자리

            while(first<last){
                if(first==i){
                    //현재 숫자가 왼쪽부터 읽어온 숫자와 겹치면 지나치도록
                    first++;
                    continue;
                }

                if(last==i){
                    //현재 숫자가 오른쪽부터 읽어온 숫자와 겹치면 지나치도록
                    last--;
                    continue;
                }

                if(numList[first]+numList[last]==currentNum){
                    goodNum++;
                    break;
                } else if (numList[first]+numList[last]>currentNum) {
                    last--;
                }else{
                    first++;
                }



            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(goodNum+"");
        bw.flush();
        bw.close();
    }

}
