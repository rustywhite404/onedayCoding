package hh99_3week.advance;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물14235_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalVisit = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < totalVisit; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int order = Integer.parseInt(st.nextToken());
            if(order==0){
                if(pq.isEmpty()){
                    bw.write("-1");
                    bw.newLine();
                }else{
                    bw.write(pq.poll()+" ");
                    bw.newLine();
                }
            }else{
                for(int j=0;j<order;j++){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
