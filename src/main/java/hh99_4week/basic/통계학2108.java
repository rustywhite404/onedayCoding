package hh99_4week.basic;

import java.io.*;
import java.util.*;

public class 통계학2108 {
    /*
     * 입력받은 수 N개로 산술평균, 중앙값, 최빈값, 범위를 각각 구하는 문제.
     * Math, Collections에서 찾거나 직접 구해서 풀 수 있을 것 같음
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList();
        //리스트 초기화
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        //리스트 크기
        int size = list.size();

        //산술평균 :
        double avg = 0;
        for (Integer i : list) {
            avg += i;
        }
        avg /= size;
        bw.write(Math.round(avg)+" ");
        bw.newLine();

        //중앙값 : 오름차순으로 나열하고 중앙에 위치하는 값
        Collections.sort(list);
        //중앙값 번호
        int center = size/2;
        bw.write(list.get(center)+" ");
        bw.newLine();

        //최빈값 :
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int value = Collections.max(map.values());
        List<Integer> valueList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==value){
                valueList.add(entry.getKey());
            }
        }

        if(valueList.size()>=2){
            Collections.sort(valueList);
            bw.write(valueList.get(1)+" ");
        }else{
            bw.write(valueList.get(0)+" ");
        }
        bw.newLine();


        //범위 :
        int max = Collections.max(list);
        int min = Collections.min(list);
        bw.write(max-min+" ");

        bw.flush();
        bw.close();
    }
}
