package level01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class solve2588 {
    public static void main(String[]args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(br.readLine()); //472
            int b = Integer.parseInt(br.readLine()); //385
            System.out.println(a*(b%10));
            System.out.println(a*((b%100)/10));
            System.out.println(a*((b/100)));
            System.out.println(a*b);
        }

}
