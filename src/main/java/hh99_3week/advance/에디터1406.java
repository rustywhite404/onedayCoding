package hh99_3week.advance;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
//이렇게 푸니까 시간 초과가 뜸. Stack을 이용한 다른 풀이를 사용해보기로 함
public class 에디터1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        int current = word.length();
        //LinkedList에 문자열 입력
        for (int i = 0; i < word.length(); i++) {
            list.add(word.charAt(i));
        }
        int count = Integer.parseInt(br.readLine()); //입력받을 명령어 숫자
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()){
                case "L":
                    if(current>0){
                        current--;
                    }
                    break;
                case "D":
                    if(current<list.size()){
                        current++;
                    }
                    break;
                case "B":
                    if(current>0){
                        list.remove(current-1);
                        current--;
                    }
                    break;
                case "P":
                    list.add(current,st.nextToken().charAt(0));
                    current++;
                    break;
            }
        }

        for (Character c : list) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
}
