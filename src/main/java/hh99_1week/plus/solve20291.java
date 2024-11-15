package hh99_1week.plus;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class solve20291 {
    /*
    * 문제 분석 :
    * - 첫줄에 분석해야 하는 파일의 갯수가 주어진다
    * - 둘쨋줄부터 n개의 파일명.확장자 가 주어진다. 확장자는 중복 될 수 있다.
    * - 각 확장자를 알파벳순으로 출력하고, 몇 번 등장하는지 카운트
    *
    * 풀이 전략 :
    * - TreeMap에 키, 값으로 저장하고 키가 같은 경우 값을 증가시킨다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Map<String, Integer> list = new TreeMap<>(); //알파벳 순 출력을 위해 TreeMap 사용
        for(int i=0;i<total;i++){
            String[] file = br.readLine().split("\\.");
            if(list.containsKey(file[1])){
                //해당하는 키의 값 변경
                list.put(file[1],list.get(file[1])+1);
            }else{
                list.put(file[1],1);
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : list.entrySet()) {
            bw.write(stringIntegerEntry.getKey()+ " "+stringIntegerEntry.getValue());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
