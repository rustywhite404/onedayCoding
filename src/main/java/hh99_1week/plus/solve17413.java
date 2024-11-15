package hh99_1week.plus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class solve17413 {
    /*
    * 문제 분석 :
    * - 문자열 S가 주어지는데, <와 >로 감싸진 태그는 그대로 두고 나머지 단어들은 뒤집어서 출력한다.
    *
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        List<String> list = new ArrayList<>();
        StringBuilder sb;
        //word에 단어가 남아있는 동안 실행
        while (word.length()>0){
            //<로 시작하는 지 확인
            if(word.charAt(0)==('<')){
                // <로 시작하면 >의 위치 확인
                int last = word.indexOf(">");
                // 0부터 last 까지 잘라서 배열에 넣기
                list.add(word.substring(0,last+1));

                //배열에 넣은 문자 제거하기(처음 한 번만)
                word = word.substring(last+1);
            }else{
                // <로 시작하지 않으면 최초로 등장하는 <의 위치 확인
                int first = word.indexOf("<");
                    // <가 없으면(-1) 전체 문자열 뒤집기. 공백 기준으로 문자열을 끊어서 뒤집어야 한다.
                    if(first==-1){
                        String[] words = word.split(" ");
                        for(int i=0;i< words.length;i++){
                            sb = new StringBuilder(words[i]);
                            words[i] = sb.reverse().toString();
                        }
                        list.add(String.join(" ",words));
                        // 처리를 끝내면 더 이상 반복할 필요가 없으므로 반복문 종료
                        break;
                    }else{
                        // <가 있으면
                        // 0부터 최초 <의 앞까지 자른다
                        String temp = word.substring(0,first);
                        // 자른 문자열을 공백 기준으로 끊어서 뒤집는다.
                        String[] tempWords = temp.split(" ");
                        for(int i=0;i< tempWords.length;i++){
                            sb = new StringBuilder(tempWords[i]);
                            tempWords[i] = sb.reverse().toString();
                        }
                        list.add(String.join(" ",tempWords));

                        //배열에 넣은 문자 제거하기(처음 한 번만)
                        word = word.substring(first);
                    }
            }
        }

        for (String s : list) {
            bw.write(s);
        }

        bw.flush();
        bw.close();
    }
}
