package 브루트포스;

import java.io.*;
import java.util.Arrays;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = 0;
        int[] arr = new int[9];
        for(int i=0;i<9;i++){
            int current = Integer.parseInt(br.readLine());
            total += current;
            arr[i] = current;
        }

        Arrays.sort(arr);
        int target = total-100;
        int fake1 = 0, fake2 = 0;

        for(int i=0;i<9;i++){
           for(int j=i+1;j<9;j++){
               if(arr[i]+arr[j]==target){
                    fake1 = arr[i];
                    fake2 = arr[j];
                    break;
               }
           }
        }

        for(int i : arr){
            if(i==fake1 || i==fake2){
                continue;
            }
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
