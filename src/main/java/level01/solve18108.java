package level01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve18108 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        //불기 = 서기+543(기원전)
        //불기는 석가모니 입적 해를 무엇으로 보냐에 따라 정의가 여러개라고 한다. 백준에서는 +543을 사용하는 듯
        System.out.println(a-543);
        }

}
