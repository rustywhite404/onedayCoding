package level01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve11382 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        //이 문제 ide에선 문제가 없었는데 제출하면 계속 틀렸다고 해서 찾아보니
        //문제 조건의 입력값 범위가 10의 12승 까지로 되어 있었다.
        //int가 처리할 수 없는 범위이므로 long으로 타입을 바꿔주니 성공함
        System.out.println(a+b+c);
        }

}
