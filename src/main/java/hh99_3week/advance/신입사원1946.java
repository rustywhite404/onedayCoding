package hh99_3week.advance;

import java.io.*;
import java.util.*;

public class 신입사원1946 {
    /*
    * 입력 :
    * - 테스트 케이스의 개수 T
    * - 각 케이스의 첫줄에 지원자 수 N
    * - 2~N줄에는 서류심사 성적 A, 면접 성적 B 가 주어짐
    *
    * 연산 :
    * - 서류심사 성적순으로 정렬하고, 면접 성적을 비교했을 때 뒷사람에 비해 떨어지지 않는 사람들만 합격.
    * - => 각 항목들에 순서가 있어야 하는데 키-값 쌍이어야 함.
    *
    *
    * 출력 :
    * - 연산 결과에 따른 신입사원의 최대 숫자를 케이스 별로 하나씩 출력
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = Integer.parseInt(br.readLine());


        for(int i=0;i<caseCount;i++){
            int personCount = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for(int j=0;j<personCount;j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                list.add(new int[]{paper, interview});
            }
            //서류심사 성적을 기준으로 오름차순 정렬
            list.sort(Comparator.comparingInt(a -> a[0]));

            int count = 1; //서류심사 1등은 무조건 합격
            int minInterviewScore = list.get(0)[1]; //첫번째 지원자의 면접 성적

            for(int j=1; j<personCount; j++){
                int interviewScore = list.get(j)[1];
                if(interviewScore<minInterviewScore){ //면접 순위가 이전 사람보다 높은 사람은 합격
                    count++;
                    minInterviewScore = interviewScore; //면접 성적 갱신
                }
            }
            bw.write(count+" ");
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }
}
