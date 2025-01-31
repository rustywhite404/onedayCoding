package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 카드_11652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            long current = Long.parseLong(br.readLine());
            if (map.containsKey(current)) {
                map.put(current, map.get(current)+1);
            } else {
                map.put(current, 0);
            }
        }
        long maxValue = Collections.max(map.values());

        long minKey = Long.MAX_VALUE;
        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            if(entry.getValue() == maxValue && entry.getKey() < minKey){
                minKey = entry.getKey();
            }
        }

        bw.write(minKey+" ");
        bw.flush();
        bw.close();
    }
}
