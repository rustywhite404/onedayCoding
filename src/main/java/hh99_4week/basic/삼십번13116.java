package hh99_4week.basic;

import java.io.*;
import java.util.StringTokenizer;

public class 삼십번13116 {
    /*
    * 문제 해석 :
    * - 1부터 1023까지의 수 중에서 자식 노드 a가 1까지 올라가는 경로와 b가 1까지 올라가는 경로에
    * - 공통으로 포함된 꼭지점(=제일 먼저 만나는 꼭지점) 중에 가장 큰 수를 M(a,b) 라고 한다.
    * - ex. M(4,11)=2
    * - M(a,b)=k라고 할 때 10k의 값을 구하시오
    *
    * 풀이 전략 :
    * - 부모 노드 : 자식 노드/2다. (ex. 노드8의 부모는 4, 15의 부모는 7)
    * - 자식 노드 : (왼)현재노드 * 2 / (오)현재노드*2+1
    * - 두 노드의 부모를 따라 올라가면서(/2 반복) 공통 조상을 찾는다
    * - 두 노드의 번호가 같아지면 => 가장 가까운 공통 조상이다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        for(int i=0; i<total;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while (a!=b){
                if(a>b){
                    a/=2;
                }else{
                    b/=2;
                }
            }
            bw.write(a*10+" ");
        }
        bw.flush();
        bw.close();
    }
}
