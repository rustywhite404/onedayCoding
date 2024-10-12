package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solve5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] studentList = new boolean[31];
        for(int i=1;i<=28;i++){
            studentList[Integer.parseInt(br.readLine())]=true;
        }
        for(int k=1;k<=30;k++){
            if(!studentList[k]){
                bw.write(String.valueOf(k));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
