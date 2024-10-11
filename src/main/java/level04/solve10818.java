package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class solve10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;total>i;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int max = Collections.max(arr);
        int min = Collections.min(arr);
        bw.write(min+" "+max);
        bw.flush();
        bw.close();
    }
}
