package hh99_3week.basic;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class solve10866 {
    /*
    * 문제 분석 : Deque를 구현하고, 명령에 가장 적절한 메서드를 사용해본다.
    * 풀이 전략 :
    * 지난번에는 peekFirst 등을 사용하고 null 여부를 체크해서 분기를 나눴는데
    * 이번에는 바로 isEmpty로 분기를 나눴다.
    * 메모리 : 이번 풀이가 20KB 절약됨 / 시간 : 저번 풀이가 4ms 절약됨 (큰 차이가 나지는 않는 듯 하다)
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        int total = Integer.parseInt(br.readLine());
        for(int i=0;i<total;i++){
            String order = br.readLine();
            int X = 0;
            st = new StringTokenizer(order," ");
            switch (st.nextToken()){
                case "push_front" :
                    X = Integer.parseInt(st.nextToken());
                    deque.addFirst(X);
                    break;
                case "push_back" :
                    X = Integer.parseInt(st.nextToken());
                    deque.addLast(X);
                    break;
                case "pop_front" :
                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(deque.pollFirst()+" ");
                        bw.newLine();
                    }
                    break;
                case "pop_back" :
                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(deque.pollLast()+" ");
                        bw.newLine();
                    }
                    break;
                case "size" :
                    bw.write(deque.size()+" ");
                    bw.newLine();
                    break;
                case "empty" :
                    if(deque.isEmpty()){
                        bw.write("1");
                        bw.newLine();
                    }else{
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "front" :
                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(deque.getFirst()+ " ");
                        bw.newLine();
                    }
                    break;
                case "back" :
                    if(deque.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(deque.getLast()+" ");
                        bw.newLine();
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
