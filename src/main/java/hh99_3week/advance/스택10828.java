package hh99_3week.advance;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){
                case "push":
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(stack.pop()+" ");
                        bw.newLine();
                    }
                    break;
                case "size":
                    bw.write(stack.size()+" ");
                    bw.newLine();
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write("1");
                        bw.newLine();
                    }else {
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                       bw.write("-1");
                        bw.newLine();
                    }else {
                        bw.write(stack.peek()+" ");
                        bw.newLine();
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
