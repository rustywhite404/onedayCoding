package level05;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve1152 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>0){
                count += 1;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
