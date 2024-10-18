package level07;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class solve2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Arrays.stream(arr).flatMapToInt(Arrays::stream).max().orElseThrow();
        bw.write(String.valueOf(max));
        bw.newLine();
        boolean findResult = false;
        for(int i=0;i<9 && !findResult ;i++){
            for(int j=0;j<9;j++){
                if(arr[i][j] == max){
                    bw.write((i+1)+" "+(j+1));
                    findResult = true;
                    break;
                }
            }
        }

        bw.flush();
        bw.close();

    }
}
