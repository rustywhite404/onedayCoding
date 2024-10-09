package level03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = num/4;
        for(int i=1;i<=count;i++){
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
