package hh99_3week.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashing15829 {
    /*
     * 입력 :
     * - 문자열의 길이 L
     * - 영문 문자열
     *
     * 연산 :
     * - 수식을 해석하면 다음과 같다 : hash = (s[0] * r^0 + s[1] * r^1 + s[2] * r^2 + ... + s[n-1] * r^(n-1)) % m
     * - 여기서 주어지는 r = 31로 고정
     * - 여기서 주어지는 m = 1234567891로 고정
     * - 즉, s[i]로 주어진 문자열의 i번째 문자에 해당하는 숫자값에, r의 제곱근을 곱하고
     * - 이 수들을 모두 더한 후 결과를 m으로 나눈다
     * 출력 :
     * - 연산을 거쳐 나온 해시값을 정수로 출력
     *
     * 풀이 후기 :
     * 처음에 Math.pow로 풀었더니 50점밖에 안 나와서 시간이 좀 걸렸다.
     * 값이 너무 커져서 오버플로우 되는 걸 방지하기 위해 중간중간 %m을 해서 모듈러 연산을 해줘야 한다는 걸 배움.
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        String word = br.readLine();
        char c = 'a';
        long result = 0; //결과값을 담을 변수
        long rPower = 1; //r^i를 저장할 변수
        int r = 31;
        long m = 1234567891;
        List<Integer> numList = new ArrayList<>();

        //알파벳-값 이 들어있는 테이블을 만든다
        Map<String, Integer> alphabetTable = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            alphabetTable.put(String.valueOf(c), i);
            c++;
        }
        //문자열의 각 자리에 해당하는 숫자들을 int[]에 담는다
        for (int i = 0; i < length; i++) {
            numList.add(alphabetTable.get(String.valueOf(word.charAt(i))));
        }

        for (int i = 0; i < numList.size(); i++) {
            //중간 계산에서 %m 연산 미리 적용
            result = (result + (numList.get(i) * rPower) % m) % m; // 안전하게 처리하려고 %m을 한번 더해준다.
            rPower = (rPower * r) % m; // r^i 값을 업데이트하면서 mod m 적용
        }
        bw.write(result + " ");
        bw.flush();
        bw.close();

    }
}
