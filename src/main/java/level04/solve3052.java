package level04;

import java.io.*;
import java.util.*;

public class solve3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a;
        int b[] = new int[10];
        int count = 1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<10;i++){
            a = Integer.parseInt(br.readLine());
            set.add(a%42);
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}
