package level06;

import java.io.*;
import java.util.StringTokenizer;

public class solve3003 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int collect[] = new int[]{1,1,2,2,2,8};
        int white[] = new int[6];
        for(int i=0;i<6;i++){
            white[i] = Integer.parseInt(st.nextToken());
        }
        for(int j=0;j<6;j++){
            if(collect[j]!=white[j]){
                bw.write(collect[j]-white[j]+" ");
            }else{
                bw.write(0+" ");
            }
        }
        bw.flush();
        bw.close();

    }
}
