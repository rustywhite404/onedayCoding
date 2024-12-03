package hh99_3week.advance;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 식당입구대기줄26042 {
    /*
    * 입력 :
    * - 첫줄에 케이스 수 N이 주어진다
    * - 이후 N번동안 1, 2중에 한가지 유형이 주어진다
    * - 1 a : 학번 a인 학생 1명이 식당 입구 맨 뒤에 줄을 선다
    * - 2 : 식사 1인분이 준비되어 맨 앞 학생이 밥을 먹으러 들어간다
    *
    * 연산 :
    * - 선입선출이므로 데크를 사용해서 구현
    * - 현재 대기열 숫자를 체크, 대기열이 최대인 경우 최대값을 갱신하며 학생의 학번도 저장
    * - 1이면 push하고 2면 poll
    *
    * 출력 :
    * - 대기중인 학생의 수가 최대가 되었던 순간의 학생 수, 맨 뒤에 대기중인 학생의 번호를 빈 칸을 사이에 두고 순서대로 출력
    * - 대기하는 학생 수가 최대인 경우가 여러번이라면, 맨 뒤에 서 있는 학생 번호가 가장 작은 경우를 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Deque<Integer> watingList = new ArrayDeque();
        int lastStudentNum = 0; //맨 뒤 대기열의 학번
        int watingCount = 0; //현재 웨이팅 인원 수
        int maxWatingCount = 0; //웨이팅 인원이 최대가 되었을 때
        for(int i=0; i<total;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){ //1번 케이스
                int studentNum = Integer.parseInt(st.nextToken()); //학번
                watingList.addLast(studentNum);
                watingCount++;

                if(watingCount>maxWatingCount){ //현재 웨이팅 수가 기존 최대 대기열보다 많을 경우 갱신
                    maxWatingCount = watingCount;
                    lastStudentNum = studentNum; //현재 맨 뒤에 들어온 학생을 저장한다
                } else if (watingCount == maxWatingCount) { //최대 대기열 수가 같은 경우가 여러번 생길 경우
                    lastStudentNum = (lastStudentNum<studentNum)?lastStudentNum:studentNum; //기존값과 방금 갱신된 값 중에 더 학번이 작은 쪽을 lastStudentNum으로
                }

            }else{ //2번 케이스
                watingList.pollFirst();
                watingCount--;
            }
        }
        bw.write(maxWatingCount+" "+lastStudentNum);
        bw.flush();
        bw.close();
    }
}
