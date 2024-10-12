package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class solve1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        double avg = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=total;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int max = Collections.max(arr);
        for(int j=0;j<arr.size();j++){
            avg += ((double)arr.get(j)/max*100);
        }
        avg = avg/arr.size();
        bw.write(String.valueOf(avg));
        bw.flush();
        bw.close();
    }
}
