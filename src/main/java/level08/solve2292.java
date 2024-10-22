package level08;

import java.io.*;

public class solve2292 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        //1층 = 2-7 / 6개
        //2층 = 8-19 / 12개
        //3층 = 20-37 / 18개
        //6의 배수로 증가
        int layer = 1; //현재 레이어
        int currentRoom = 1; //현재 방번호

        while (currentRoom<num){
            currentRoom += 6*layer;
            layer++;
        }
        bw.write(String.valueOf(layer)); //result
        bw.flush();
        bw.close();
    }
}
