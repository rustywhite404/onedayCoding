package hh99_3week.basic;

import java.io.*;
import java.util.*;

public class 전주듣고노래맞히기31562 {
    /*
     * 입력 :
     * - 첫 줄에 음을 아는 노래의 개수 N, 맞히기를 시도할 노래의 개수 M
     * - 2~N번째 줄에 노래 제목의 길이 T, 문자열 노래제목 S, 해당 노래의 음이름 7자리가 공백으로 구분되어 주어짐
     * - N+2줄부터 M개의 줄에 걸쳐 맞히기를 시도할 노래의 첫 세 음의 음이름이 공백으로 구분되어 주어짐.
     *
     * 연산 :
     * - 해시테이블에 노래제목, 음이름 배열을 저장
     * - 입력받은 세개의 음이름과 value의 첫 세자리를 비교한다
     * - 하나라도 다를 경우 해시테이블에서 삭제 => 문제를 잘못 이해함.
     * - 삭제하면 안 되고, 전부 일치할 경우 새로운 배열에 값을 저장하기로 함.
     * - 연산이 끝난 후 저장한 배열의 사이즈를 확인한 후 출력한다
     *
     * 출력 :
     * - 저장된 노래와 첫 세 음이 동일한 노래가 하나라면 해당 노래의 제목을,
     * - 두 개 이상이면 ?를
     * - 없다면 !를 한 줄에 하나씩 출력한다.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //음을 아는 노래의 개수
        int M = Integer.parseInt(st.nextToken()); //맞히기를 시도할 노래의 개수
        Map<String, String[]> musicList = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int subLength = Integer.parseInt(st.nextToken()); //노래 제목의 길이
            String subject = st.nextToken(); //노래 제목
            String[] pitchNameList = new String[7];
            //이 노래의 음이름 7개
            for (int j = 0; j < 7; j++) {
                pitchNameList[j] = st.nextToken();
            }
            //해시테이블에 키값을 넣기
            musicList.put(subject, pitchNameList);
        }

        for (int i = 0; i < M; i++) {
            List<String> matchedList = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            String[] inputPitches = new String[3];

            //입력받은 세 음의 이름을 배열로 저장
            for(int j=0;j<3;j++){
                inputPitches[j] = st.nextToken();
            }

            for (Map.Entry<String, String[]> temp : musicList.entrySet()) {
                boolean isMatched = true;
                String[] tempValue = temp.getValue();
                for (int k = 0; k < 3; k++) {
                    //입력받은 세개의 음이름과 value의 첫 세자리를 비교한다
                    if (!inputPitches[k].equals(tempValue[k])) {
                        isMatched = false;
                        break;
                    }
                }
                //반복이 끝났을 때 isMatched가 true면 key를 matchedList에 넣는다
                if(isMatched){
                    matchedList.add(temp.getKey());
                }
            }
            //반복이 끝난 후에 matchedList에 들어있는 값의 숫자로 결과값 출력

            if (matchedList.isEmpty()) {
                bw.write("!");
                bw.newLine();
            } else if (matchedList.size() >= 2) {
                bw.write("?");
                bw.newLine();
            } else {
                bw.write(matchedList.get(0));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();

    }
}
