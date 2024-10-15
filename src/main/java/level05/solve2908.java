package level05;

import java.io.*;
import java.util.StringTokenizer;

public class solve2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[3];
        int[] arr2 = new int[3];
        //734
        for(int i=0;i<3;i++){
            arr[i] = a%10;
            arr2[i] = b%10;
            a/=10;
            b/=10;
        }

        int reverseA = arr[0]*100+arr[1]*10+arr[2];
        int reverseB = arr2[0]*100+arr2[1]*10+arr2[2];
        bw.write(String.valueOf(Math.max(reverseA,reverseB)));
        bw.flush();
        bw.close();
    }
}
