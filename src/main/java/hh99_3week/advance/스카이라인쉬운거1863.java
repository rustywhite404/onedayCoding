package hh99_3week.advance;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거1863 {
    /*
     * 입력 :
     * - 건물의 갯수 N
     * - 건물의 좌표 X, Y
     *
     * 연산 :
     * - 건물의 높이가 기존 값보다 커지면 PUSH
     * - 건물의 높이가 기존 값보다 작아지면 POP 하면서 건물 수 +1
     * - 건물 높이가 기존 값과 같으면 같은 건물일 가능성이 있으므로 유지
     * - 반복 종료 후에 스택에 값이 남아있을 경우, 0 이상이면 아직 건물이 남아있는 거니까 건물 수 +1 하면서 POP(0이 될때까지 반복)
     *
     * 출력 :
     * - 건물의 숫자를 구한다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int buildingCount = 0;
        Stack<Integer> skyline = new Stack<>();

        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //스택에 값이 있고, 스택의 최상위 값이 y보다 크면 => 높이가 낮아졌다. 건물이 끝났다는 의미
            while (!skyline.isEmpty() && skyline.peek()>y){
                buildingCount++; //건물 하나를 더해주고
                skyline.pop(); //끝난 건물을 반환
            }
            //스택에 값이 있고, 새로 입력된 y값과 기존 높이가 같을 경우 => 같은 빌딩일 가능성이 있으므로 유지
            if(!skyline.isEmpty() && skyline.peek()==y){
                continue;
            }
            //스택에 값이 없거나, 스택의 최상위 값보다 y가 크면 => 높이가 높아진 경우. 건물의 높이 갱신
            skyline.push(y);
        }

        //반복문이 종료된 후에도 스택이 비어있지 않은 경우
        while (!skyline.isEmpty()){
            if(skyline.peek()>0){
                buildingCount++;
            }
            skyline.pop();
        }

        bw.write(buildingCount + " ");
        bw.flush();
        bw.close();
    }
}
