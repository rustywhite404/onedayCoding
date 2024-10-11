package level04;

import java.io.*;
import java.util.StringTokenizer;

public class solve10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int[] nums = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int pick = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0;i<total;i++){
            nums[i] = Integer.parseInt(st.nextToken());
            if(nums[i]==pick){
                count += 1;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
