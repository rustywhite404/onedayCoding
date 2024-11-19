package hh99_1week.plus;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class solve10866 {
    /*
    * 문제 분석 :
    * 다음 명령을 처리하는 덱Deque 프로그램을 구현하라.
    push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    * // 처음에 getFirst()로 구현했더니 null일때 null 반환이 허용되지 않아 에러가 났다.
    * // null 반환을 하고 싶다면 peekFirst()를 사용해야 한다. getLast와 peekLast도 마찬가지.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String order = st.nextToken();
            Integer temp;
            switch (order){
                case "push_front" :
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back" :
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    temp = deque.pollFirst();
                    if(temp==null){
                        bw.write("-1");
                        bw.newLine();
                    }else{
                        bw.write(temp+" ");
                        bw.newLine();
                    }
                    break;
                case "pop_back" :
                    temp = deque.pollLast();
                    if(temp==null){
                        bw.write("-1");
                        bw.newLine();
                    }else{
                        bw.write(temp+" ");
                        bw.newLine();
                    }
                    break;
                case "size" :
                    bw.write(deque.size()+" ");
                    bw.newLine();
                    break;
                case "empty" :
                    if(deque.isEmpty()){
                        bw.write("1");
                        bw.newLine();
                    }else{
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "front" :
                    temp = deque.peekFirst();
                    if(temp==null){
                        bw.write("-1");
                        bw.newLine();
                    }else{
                        bw.write(temp+" ");
                        bw.newLine();
                    }
                    break;
                case "back" :
                    temp = deque.peekLast();
                    if(temp==null){
                        bw.write("-1");
                        bw.newLine();
                    }else{
                        bw.write(temp+" ");
                        bw.newLine();
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
