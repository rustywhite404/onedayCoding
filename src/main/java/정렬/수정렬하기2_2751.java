package 정렬;

import java.io.*;
import java.util.*;
public class 수정렬하기2_2751{

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];
        for(int i=0;i<num;i++){
            int current = Integer.parseInt(br.readLine());
            nums[i] = current;
        }
        Arrays.sort(nums);
        for(int i:nums){
            bw.write(i+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
}
}