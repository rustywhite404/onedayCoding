package hh99_3week.advance;

import java.io.*;
import java.util.PriorityQueue;

public class 최소힙1927 {
    /*
     * 입력 :
     * - 첫줄에 연산의 개수 N
     * - N개의 줄 : 정수 X가 주어짐
     * - X가 자연수라면 배열에 X라는 값을 넣고, X가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.
     *
     * 출력 :
     * - 입력에서 0이 주어진 만큼 답을 출력한다.
     * - 배열이 비어있는데 출력하라고 한다면 0을 출력한다.
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //힙은 기본으로 최소값이 제일 위로 감
        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(queue.isEmpty()){
                    bw.write("0");
                    bw.newLine();
                }else{
                    bw.write(queue.poll()+" ");
                    bw.newLine();
                }
            }else{
                queue.add(num);
            }
        }
        bw.flush();
        bw.close();
    }
}
