package level02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        // 23<a면 a = 0
        //b+c가 60이상이면 a에 +1, b=(b+c)-60
        //b+c가 60이하면 b+c...하기보다는
        //분으로 전부 변환해서 계산 후에 시/분으로 변환하면 훨씬 편하다

        int sum = a*60+b+c;
        int hour = sum/60;
        int min = sum%60;
        if(hour>=24) {
            hour%=24;
        }
        System.out.println(hour+" "+min);


    }
}
