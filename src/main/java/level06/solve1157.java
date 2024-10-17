package level06;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class solve1157 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char alphabet = 65;
        String word = br.readLine().toUpperCase();
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<26;i++){ //배열에 알파벳을 키로 넣고 값을 0으로 초기화
            map.put(alphabet,0);
            alphabet++;
        }
        //각 문자의 빈도수 카운트
        for(int j=0;j<word.length();j++){
            Character currentChar = word.charAt(j);
//            if(map.containsKey(currentChar)){
//                map.put(currentChar,map.get(currentChar)+1);
//            }
            //map.merge를 이용하면 키를 매번 찾지 않고도 좀 더 간단하게 키값을 업데이트 할 수 있다
            map.merge(currentChar,1, Integer::sum);

        }
        //value에서 최대값 찾기
        int max = Collections.max(map.values());
        //중복여부 확인
        boolean duplicate = false;
        //답 입력
        Character result = '?';

        for(Map.Entry<Character, Integer> m:map.entrySet()){
            if(m.getValue()==max){
                if(result=='?'){
                    result = m.getKey(); //처음으로 최대값과 일치한 알파벳
                }else {
                    duplicate = true; //최대값 중복될 경우
                    break; //중복이 발생하면 바로 중단해도 됨
                }
            }
        }
        //중복 여부에 따라 출력
        if(duplicate){
            bw.write("?");
        }else{
            bw.write(result);
        }
        bw.flush();
        bw.close();
    }
}
