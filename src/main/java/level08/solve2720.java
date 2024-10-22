package level08;

import java.io.*;
import java.util.StringTokenizer;

public class solve2720 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i=0;i<count;i++){
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penny = 0;
            int cent = Integer.parseInt(br.readLine());
            quarter = cent/25;
            cent %= 25;
            dime = cent/10;
            cent %= 10;
            nickel = cent/5;
            cent %= 5;
            penny = cent;
            bw.write(quarter+" "+dime+" "+nickel+" "+penny);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
