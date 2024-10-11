package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int total = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<total;i++){
          arr.add(Integer.parseInt(st2.nextToken()));
        }
        for(int j:arr){
            if(j<num){
                bw.write(j+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
