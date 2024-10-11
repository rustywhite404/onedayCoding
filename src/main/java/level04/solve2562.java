package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solve2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<9;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        int max = Collections.max(arr);
        int count = arr.indexOf(max)+1;
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
