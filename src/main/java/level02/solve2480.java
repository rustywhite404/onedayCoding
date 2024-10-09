package level02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = 0;

        if(a==b&&b==c){
            //a랑 b가 같으면서 b랑 c도 같은 경우
            sum = 10000+a*1000;
        }else if(a==b&&a!=c){
            //a랑 b는 같은데 a랑 c는 다른 경우
            sum = 1000+a*100;
        }else if(a==c&&a!=b){
            //a랑 c는 같은데 a랑 b는 다른 경우
            sum = 1000+a*100;
        }else if(b==c&&b!=a){
            //b랑 c는 같은데 b랑 a는 다른 경우
            sum = 1000+b*100;
        }else if(a!=b&&b!=c){
            //a랑 b가 다르면서 b랑 c도 다른 경우
            int max = Math.max(Math.max(a,b),c);
            sum = max*100;
        }
        System.out.println(sum);
    }
}
