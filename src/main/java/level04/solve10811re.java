package level04;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve10811re {
    public static void main(String[] args) throws IOException{
        //역순으로 값 넣는 부분에서 좀 버벅였어서 정리 겸 복기함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int total = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int a, b = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        //arr초기세팅
        for(int i=1;i<=total;i++){
            arr.add(i);
        }
        //count번 교환
        for(int j=0;j<count;j++){
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken())-1; //arr이 0부터 시작해서 바꿔줌
            b = Integer.parseInt(st.nextToken())-1; //상동
            //역순으로 바꿔주기
            while (a<b){
                int temp = arr.get(a);
                arr.set(a,arr.get(b));
                arr.set(b,temp);
                a++;
                b--;
            }
        }
        //배열 출력
        for(int k:arr){
            bw.write(k+" ");
        }
        bw.flush();
        bw.close();
    }
}
