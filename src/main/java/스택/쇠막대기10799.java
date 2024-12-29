package 스택;

import java.io.*;
import java.util.Stack;

public class 쇠막대기10799 {
    /*
    * 문자열을 하나씩 읽는다.
    * 여는 괄호(는 스택에 추가.
    * 닫는 괄호 )는 레이저인지, 쇠막대기 끝인지 판별.
    * 레이저일 경우, 스택의 크기 만큼 조각을 추가
    * 쇠막대기 끝일 경우, 조각을 하나 추가
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i=0;i<input.length();i++){
            char current = input.charAt(i);
            if(current=='('){ //여는 괄호는 스택에 추가
                stack.push(current);
            }else if(current==')'){ //닫는 괄호는 레이저인지 쇠막대기인지 판별
                if (!stack.isEmpty()) {
                    stack.pop(); // 스택이 비어 있지 않을 때만 pop
                }
                if(input.charAt(i - 1) == '('){ //바로 앞 문자가 (였으면 레이저
                    result += stack.size();
                }else{ //쇠막대기였으면 조각 하나 추가
                    result ++;
                }
            }

        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
