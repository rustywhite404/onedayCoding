package 브루트포스;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 아맞다마늘_32978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            map.put(st.nextToken(), 0);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < total - 1; i++) {
            String current = st.nextToken();
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            }
        }
        for(String key : map.keySet()){
            if(map.get(key)==0){
                bw.write(key);
            }
        }
        bw.flush();
        bw.close();
    }
}
