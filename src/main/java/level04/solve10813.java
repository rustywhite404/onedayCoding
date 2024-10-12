package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int basket = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        int l, m, temp;
        for(int i=1;i<=basket;i++){
            arr.add(i);
        }
        for(int j=1;j<=count;j++){
            st = new StringTokenizer(br.readLine()," ");
            l = Integer.parseInt(st.nextToken())-1;
            m = Integer.parseInt(st.nextToken())-1;
            temp = arr.get(l);
            arr.set(l, arr.get(m));
            arr.set(m, temp);
        }
        for(int k:arr){
            bw.write(String.valueOf(k+" "));
        }
        bw.flush();
        bw.close();

    }
}
