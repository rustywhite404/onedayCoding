package hh99_1week.plus;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class solve1302 {
    /*
    * 문제 분석 :
    * - 첫줄에 책의 총 권수 n이 주어진다.
    * - 둘쨋줄부터 n개의 줄에 제목이 입력된다.
    * - 각 책의 권수를 카운트해서, 제일 많이 팔린 책의 제목을 출력한다.
    * - 가장 많이 팔린 책이 여러개일 경우에는 사전 순으로 가장 앞선 제목을 출력한다.
    *
    * 풀이 전략 :
    * - TreeMap에 키, 값으로 저장하고 키가 같은 경우 값을 증가시킨다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Map<String, Integer> bookList = new TreeMap<>();

        //해당 책이 배열에 이미 들어와 있으면 카운트를 1 더하고, 없으면 배열에 입력한다.
        for(int i=0;i<total;i++){
            String title = br.readLine();
            if(bookList.containsKey(title)){
                bookList.put(title,bookList.get(title)+1);
            }else{
                bookList.put(title,1);
            }
        }

        // 가장 많이 팔린 책 권수 카운트
        int max = Collections.max(bookList.values());

        // 가장 value가 큰 책을 찾고, 동률일 경우 가장 앞서는 제목을 출력한다.
        // TreeMap이므로 제일 먼저 찾은 값이 제일 앞선 제목이므로 바로 값을 반환 후 반복을 종료한다.
        for (Map.Entry<String, Integer> value : bookList.entrySet()) {
            if(value.getValue()==max){
                bw.write(value.getKey());
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
