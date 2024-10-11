package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int totalBasket = Integer.parseInt(st.nextToken());
        int throwCount = Integer.parseInt(st.nextToken());
        int start, end, ballNum;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int m=0;m<totalBasket;m++){
            arr.add(0);
        }
        for(int i=1;i<=throwCount;i++){
            st = new StringTokenizer(br.readLine()," ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            ballNum = Integer.parseInt(st.nextToken());
            for(int j=start-1;j<end;j++){
               arr.set(j,ballNum);
            }
        }
        for(int k:arr){
            bw.write(k+" ");
        }
        bw.flush();
        bw.close();
    }
}
