package hh99_3week.advance;

import java.io.*;
import java.util.PriorityQueue;

public class 최소힙1927_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        PriorityQueue queue = new PriorityQueue();
        for(int i=0;i<total;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(queue.isEmpty()){
                    bw.write("0");
                    bw.newLine();
                }else{
                    bw.write(queue.poll()+" ");
                }
            }else{
                queue.add(num);
            }
        }
        bw.flush();
        bw.close();
    }
}
