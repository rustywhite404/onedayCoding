package level03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int amount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int item = 0;
        int price = 0;
        int calc = 0;
        for(int i=1;i<=amount;i++){
            st = new StringTokenizer(br.readLine()," ");
            item = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());
            calc += item*price;

        }
        if(total==calc){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
