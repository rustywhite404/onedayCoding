package level09;


import java.io.*;

public class solve11653 {
    /*
    * 입력받은 수를 소인수분해 하는 로직을 작성한다.
    *
    * 풀이 후기 :
    * 그냥 소인수분해를 하는 건 쉬운데 그걸 for문으로 구현하려고 하니 어려웠다.
    * 일단 입력받은 N을 제일 작은 소수인 i=2부터 시작해서 나눠본다.
    * 나눴을때 0이면 나눈 숫자(2)를 출력하고, N을 N/= i으로 갱신한다.
    * N이 2로 나눠지지 않으면 i를 증가시켜본다.
    * 어떤 수 N의 소인수를 구할 때, 소수의 최대값은 루트N 이하라는 성질이 있다(중요)
    * 그래서 검사는 루트 N 이하의 숫자까지만 하면 됨.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=2;i*1<=N;i++){
            while (N%i==0) {
                bw.write(i+" ");
                bw.newLine();
                N /= i;
            }
        }
        if(N>1){
            bw.write(N+" ");
        }

        bw.flush();
        bw.close();

    }
}
