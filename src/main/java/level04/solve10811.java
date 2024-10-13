package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int total = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int a, b = 0;

        for(int i=1;i<=total;i++){
            arr.add(i);
        }
        for(int j=0;j<count;j++){
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            while (a<b){
                int temp = arr.get(a);
                arr.set(a,arr.get(b));
                arr.set(b,temp);
                a++;
                b--;
            }
        }
        for(int k:arr){
            bw.write(k +" ");
        }
        bw.flush();
        bw.close();
    }
}
