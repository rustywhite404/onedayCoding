package level06;

import java.io.*;

public class solve2444_re {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        //2444번 문제 풀었던 걸 가독성 좋게 다시 고쳐 봄

        //상단 반
        for(int i=1;i<=num;i++){
            printSpace(bw,num-i);
            printStar(bw,2*i-1);
            bw.newLine();
        }
        //하단 반
        for(int i=num-1;i>=1;i--){
            printSpace(bw,num-i);
            printStar(bw,2*i-1);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    //공백 출력
    public static void printSpace(BufferedWriter bw, int count) throws IOException {
        for(int i=0;i<count;i++){
            bw.write(" ");
        }
    }

    //별 출력
    public static void printStar(BufferedWriter bw, int count) throws IOException{
        for(int i=0;i<count;i++){
            bw.write("*");
        }
    }
}
