package hh99_3week.basic;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐 {
    /*
    * 입력 :
    * - 명령의 수 N
    * - 2~N줄 까지는 명령이 하나씩 주어지고, 경우에 따라 정수 X가 함께 주어짐
    * 출력 :
    * - 각각의 명령에 따라 각각의 결과를 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(queue.poll()+" ");
                        bw.newLine();
                    }
                    break;
                case "size":
                    bw.write(queue.size()+" ");
                    bw.newLine();
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        bw.write("1");
                        bw.newLine();
                    }else {
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(queue.peek()+" ");
                        bw.newLine();
                    }
                    break;
                case "back": //큐에는 마지막 숫자를 확인할 수 있는 메서드가 없으므로 직접 구현해야 한다. 실무에서 쓸때는 데크를 쓰는게 더 편해 보임
                    if(queue.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        for(int j=0;j< queue.size()-1;j++){
                            queue.add(queue.poll());// 마지막 숫자의 앞까지 큐에서 꺼내고, 바로 다시 넣음
                        }
                        bw.write(queue.peek()+" "); // 마지막 숫자(였던 것)를 출력
                        bw.newLine();
                        queue.add(queue.poll()); //마지막 숫자도 다시 꺼냈다 넣어서 큐를 원래 상태로 만든다
                    }
                    break;
            }

        }
        bw.flush();
        bw.close();

    }
}
