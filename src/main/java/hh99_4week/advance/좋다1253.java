package hh99_4week.advance;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 좋다1253 {
    /*
    * - 투 포인터 알고리즘이라는 걸 사용해서 풀어야 한다.
    * - 우선 주어진 수들을 오름차순으로 정렬해둔다.
    * <투 포인터 정렬>
    * 첫번째 포인터는 배열의 시작부분에서 시작한다
    * 두번째 포인터는 배열의 끝부분에서 시작한다
    * 원하는 조건을 만족할 때까지 포인터를 이동시키면서 배열을 한 번만 탐색한다(선형탐색).
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<total;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //오름차순으로 배열 정리

        int goodCount = 0; //좋은 수의 개수를 셀 변수

        //각 요소에 대해 2개의 수를 찾는다
        for(int i=0;i<total;i++){
            int target = arr[i]; //이번에 대상이 되는 요소
            int left = 0; //배열의 시작번호
            int right = total-1; //배열의 끝번호


            //투 포인터 방식으로 합을 찾는다
            //둘이 서로 교차해서 지나가면 더 이상 유효한 합을 구할 수 없음. 둘이 같은 값이 된 경우에도 같은 수를 두번 더하게 되므로 안 됨.
            while (left<right){

                //각각의 수를 기준으로 합을 찾아야 하는데
                //left나 right가 i와 같으면 안되니까 한칸 이동시킴
                if(left==i){
                    left++;
                    continue;
                }
                if(right==i){
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if(sum == target){ //포인터 두개를 합쳤을 때 target과 값이 같으면
                    goodCount++; //좋은 숫자
                    break;
                }else if(sum < target){
                    left++; //합친 값보다 target이 더 크면 작은 수를 하나 키워서 비교해본다
                }else{
                    //합친 값보다 target이 더 작으면 큰 수를 하나 줄여서 비교해본다
                    right--;
                }
            }
        }
        bw.write(goodCount+" ");
        bw.flush();
    }
}
