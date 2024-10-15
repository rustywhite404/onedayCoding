package level05;

import java.io.*;
import java.util.StringTokenizer;

public class solve5622 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int sec = 0;
        String[] arr = new String[10];
        arr[0] = " ";
        arr[1] = " ";
        arr[2] = "ABC";
        arr[3] = "DEF";
        arr[4] = "GHI";
        arr[5] = "JKL";
        arr[6] = "MNO";
        arr[7] = "PQRS";
        arr[8] = "TUV";
        arr[9] = "WXYZ";
        for(int i=0;i<word.length();i++){
            String keyword = String.valueOf(word.charAt(i));
            for(int j=0;j<arr.length;j++){
                if(arr[j].contains(keyword)){
                    sec += (j+1);
                };
            }
        }
        bw.write(String.valueOf(sec));
        bw.flush();
        bw.close();
    }
}
