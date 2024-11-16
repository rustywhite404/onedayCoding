package hh99_1week.basic;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class solve25593 {
    /*
    * 문제 해석 :
    * - 첫줄에 n주가 표시된다.
    * - 1주당 4개의 줄로 표시되며,
    * - 1-1은 8:00~12:00에 근무하는 사람(4시간)
    * - 1-2는 12:00~18:00에 근무하는 사람(6시간)
    * - 1-3은 18:00~22:00에 근무하는 사람(4시간)
    * - 1-4는 22:00~08:00에 근무하는 사람이다.(10시간)
    * - 각자의 근무량이 12시간 이하로 차이나면 공평한 시간표이다.
    *
    * 풀이 전략 :
    * - 인물별 근무시간이 저장되는 hashMap을 만든다(이름, 시간)
    * - 각 라인 별 근무자명을 확인해서 근무시간을 카운트한다 ("-"이면 다음으로 넘어감)
    * - 근무시간 카운트 후, 최고근로시간과 최저근로시간이 12시간 이하로 차이나는지 확인
    * */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int week = Integer.parseInt(br.readLine());
        Map<String,Integer> workerList = new HashMap<>();
        String line;
        StringTokenizer st;
        for(int i=0;i<week;i++){
            //각 라인의 근무시간이 다르므로 한번에 4개씩 처리
            // 1. 8:00~12:00에 근무하는 사람(4시간)
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<7;j++){
                String name = st.nextToken();
                if(!name.equals("-")){
                    if(workerList.containsKey(name)){
                        workerList.put(name,workerList.get(name)+4);
                    }else {
                        workerList.put(name,4);
                    }
                }
            }

            // 2. 12:00~18:00에 근무하는 사람(6시간)
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<7;j++){
                String name = st.nextToken();
                if(!name.equals("-")){
                    if(workerList.containsKey(name)){
                        workerList.put(name,workerList.get(name)+6);
                    }else {
                        workerList.put(name,6);
                    }
                }
            }

            // 3. 18:00~22:00에 근무하는 사람(4시간)
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<7;j++){
                String name = st.nextToken();
                if(!name.equals("-")){
                    if(workerList.containsKey(name)){
                        workerList.put(name,workerList.get(name)+4);
                    }else {
                        workerList.put(name,4);
                    }
                }
            }

            // 4. 22:00~08:00에 근무하는 사람이다.(10시간)
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<7;j++) {
                String name = st.nextToken();
                if (!name.equals("-")) {
                    if (workerList.containsKey(name)) {
                        workerList.put(name, workerList.get(name) + 10);
                    } else {
                        workerList.put(name, 10);
                    }
                }
            }

        }

        // 아무도 근무하지 않았을 경우 공평한 것으로 간주한다.
        if(workerList.size()==0){
            bw.write("Yes");
        }else{
            // 반복이 끝나고 최저 근무량과 최고 근무량을 비교했을 때 차이가 12시간 이하인지 확인
            int max = Collections.max(workerList.values());
            int min = Collections.min(workerList.values());
            String result = (max-min<=12)?"Yes":"No";
            bw.write(result);
        }
        bw.flush();
        bw.close();

    }
}
