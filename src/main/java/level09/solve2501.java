package level09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class solve2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> nums = new ArrayList<>();
        //a의 약수 전체를 구한다
        for(int i=1;i<=a;i++){
            if(a%i==0){
                nums.add(i);
            }
        }

        if(nums.size()>=b){
            //약수 리스트에서 k번째 수를 출력
            bw.write(String.valueOf(nums.get(b-1)));
        }else{
            bw.write(String.valueOf(0));
        }



        bw.flush();
        bw.close();

    }
}
