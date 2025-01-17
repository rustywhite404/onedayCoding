package 이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        long[] nums = new long[total];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<total;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int left = 0;

        int right = total-1;


        long ansLeft = 0;
        long andRight = 0;
        long minSum = Integer.MAX_VALUE;
        //투 포인터 탐색
        while (left<right){
            long sum = nums[left]+nums[right];

            if(Math.abs(sum)<minSum){
                minSum = Math.abs(sum);
                ansLeft = nums[left];
                andRight = nums[right];
            }
            // 포인터 이동
            if (sum < 0) {
                left++; // 합이 음수면 왼쪽 포인터를 오른쪽으로 이동
            } else {
                right--; // 합이 양수면 오른쪽 포인터를 왼쪽으로 이동
            }
        }
        bw.write(ansLeft+" ");
        bw.write(andRight+"");
        bw.flush();
        bw.close();
    }


}
