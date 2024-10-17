package level06;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class solve2941 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croAlphabet = new String[]{"c=","c-","dz=","d-","lj","nj","s=","z="};
        //크로아티아 알파벳을 배열에 넣는다
        String word = br.readLine();
        int count = 0;
        int i = 0; //인덱스 초기화

        while(i<word.length()){
            boolean found = false;
            //입력받은 문자열에 크로아티아 알파벳이 포함되어 있는지 확인

            for(String cro:croAlphabet) {
                if(word.startsWith(cro,i)) { //크로아티아 알파벳의 길이가 현재 인덱스 안에 있고, 해당 알파벳과 일치하는지
                    count++; //크로아티아 알파벳이 존재
                    i += cro.length(); //인덱스를 크로아티아 알파벳의 길이만큼 증가
                    found = true;
                    break;
                }
            }
            //크로아티아 알파벳이 발견되지 않으면
            if(!found){
                count++; //일반 알파벳 존재
                i++; //인덱스 1 증가
            }


        }


        //남은 알파벳의 length를 카운트에 더한다
        count += word.length();
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
