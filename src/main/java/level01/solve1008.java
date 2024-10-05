package level01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve1008 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        System.out.println(a/b);

        }

}
