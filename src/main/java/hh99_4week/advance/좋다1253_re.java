package hh99_4week.advance;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다1253_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];
        //배열 값 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<total;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //오름차순으로 정렬

        int goodCount = 0;
        //투 포인터 정렬 시작
        for(int i=0;i<total;i++){
            int current = arr[i]; //이번에 구할 배열의 번호
            int left = 0; //포인터1. 배열의 시작값
            int right = total-1; //포인터2. 배열의 마지막 값

            while (left<right){ //둘이 겹치거나 교차하기 전까지 반복
                if(left==i){ //포인터 위치가 이번에 구할 배열값과 같은 자리에 있으면 옮겨준다
                    left++;
                    continue; //포인터 위치 옮겼으면 다시 처음부터
                }
                if(right==i){ //포인터 위치가 이번에 구할 배열값과 같은 자리에 있으면 옮겨준다
                    right--;
                    continue;
                }

                if(arr[left]+arr[right]==current){ //좌우 포인터의 값이 대상 배열값과 같으면
                    goodCount++;
                    break;
                } else if (arr[left]+arr[right]>current) { //대상 배열보다 크면
                    right--;
                }else{ //대상 배열보다 작으면
                    left++;
                }
            }
        }
        bw.write(goodCount+" ");
        bw.flush();
        bw.close();

    }
}
