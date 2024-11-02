package level09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class solve9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a;

        while ((a = Integer.parseInt(br.readLine())) != -1) {
            List<Integer> nums = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < a; i++) {
                //숫자 a의 약수 전체 구하기(리스트 nums)
                if (a % i == 0) {
                    nums.add(i);
                }
            }
            for (int i : nums) {
                //nums의 값 전부 더하기
                sum += i;
            }
            if (sum == a) {
                // 더한 값이 a와 같으면 완전수 true;
                bw.write(a + " = ");
                for (int i = 0; i < nums.size(); i++) {
                    if(i>0){
                        bw.write(" + ");
                    }
                    bw.write(String.valueOf(nums.get(i)));
                }
                bw.newLine();
            } else {
                bw.write(a + " is NOT perfect.");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();

    }
}
