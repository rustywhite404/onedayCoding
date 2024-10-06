package level02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(b>45){
            b = b-45;
            System.out.println(a+" "+b);
        }else{
            if(a<=0){
                a=23;
            }else{
                a=a-1;
            }
            b= 60-(45-b);
            System.out.println(a+" "+b);
        }
    }
}
