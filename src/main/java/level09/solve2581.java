package level09;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class solve2581 {
    /*
    * 입력받은 자연수 M과 N 사이의 소수를 모두 찾는다.
    * 이 소수들의 합과, 이 수들 중 최솟값이 무엇인지 찾는다.
    *
    * 풀이 전략 :
    * 일단 소수를 구해서 리스트에 넣고, 완성된 리스트에서 합치거나 최솟값을 찾는다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<Integer> primeList = new ArrayList<>();
        int primeCount = 0;
        boolean prime = true;
        for(int i=M;i<=N;i++){
            primeCount = 0;
            prime = true;
            if(i<2) continue;
            for(int j=1;j<i;j++){
                if(i%j==0){
                    primeCount++;
                    if(primeCount>1){
                        prime = false;
                        break;
                    }
                }
            }
            if(prime){
                primeList.add(i);
            }
        }

        if(primeList.isEmpty()){
            bw.write("-1");
        }else{
            //소수의 합 출력
            int sum = 0;
            for (Integer integer : primeList) {
                sum += integer;
            }
            bw.write(sum+" ");
            bw.newLine();
            //최솟값 찾아서 출력
            bw.write(Collections.min(primeList)+" ");
        }
        bw.flush();
        bw.close();

    }
}
