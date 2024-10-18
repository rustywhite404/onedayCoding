package level07;

import java.io.*;
import java.util.StringTokenizer;

public class solve2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sizeN = Integer.parseInt(st.nextToken());
        int sizeM = Integer.parseInt(st.nextToken());
        int[][] arrA = new int[sizeN][sizeM];

        for(int i=0;i<sizeN;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<sizeM;j++){
                arrA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<sizeN;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<sizeM;j++){
                arrA[i][j] += Integer.parseInt(st.nextToken());
                bw.write(arrA[i][j]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
