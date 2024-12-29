package 문자열;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 알파벳개수10808 {
    //알파벳 소문자로만 이루어진 단어 S가 주어지고, 각 알파벳이 단어에 몇 개 포함되어 있는지 구하는 프로그램을 작성. 
    //풀이전략 : 각 알파벳이 키로 주어지는 트리맵(순서대로 나와야 하므로)을 만들어서 카운트
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new TreeMap<>();
        //map 만들 때 charAt(i)-'a' 해서 반복문으로 돌리면 더 깔끔했을 듯
        map.put('a',0);
        map.put('b',0);
        map.put('c',0);
        map.put('d',0);
        map.put('e',0);
        map.put('f',0);
        map.put('g',0);
        map.put('h',0);
        map.put('i',0);
        map.put('j',0);
        map.put('k',0);
        map.put('l',0);
        map.put('m',0);
        map.put('n',0);
        map.put('o',0);
        map.put('p',0);
        map.put('q',0);
        map.put('r',0);
        map.put('s',0);
        map.put('t',0);
        map.put('u',0);
        map.put('v',0);
        map.put('w',0);
        map.put('x',0);
        map.put('y',0);
        map.put('z',0);
        
        String word = br.readLine();
        for(int i=0;i<word.length();i++){
            Character current = word.charAt(i);
            if(map.containsKey(current)){
                map.put(current,map.get(current)+1);
            }
        }

        for (Integer value : map.values()) {
            bw.write(value+" ");
        }
        bw.flush();
        bw.close();
    }
}
