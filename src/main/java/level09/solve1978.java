package level09;
import java.io.*;
import java.util.StringTokenizer;

public class solve1978 {
    /*
     * 문제 분석 :
     * - 소수 찾기. 1이 아닌 자연수 중에서, 1과 자기 자신으로만 나누어지는 수를 찾아야 한다
     *
     * 풀이 전략 :
     * - 메서드를 사용할 수도 있고 직접 구할 수도 있을 것 같은데 일단 직접 풀어보자.
     * => 답은 맞았지만 시간복잡도가 높은 구현 방식인 것 같다. 다음 번에는 수학적인 접근으로 풀어보자.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int result = 0;
        int primeCount = 0;
        boolean prime = true;
        for(int i=0;i<count;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>=2){ // 0과 1은 소수가 아니다
                primeCount = 0;
                prime = true;
                for(int j=1;j<num;j++){
                    if(num%j==0){
                        primeCount++;
                        if(primeCount>1){
                            prime = false;
                            break;
                        }
                    }
                }
                if(prime){
                    result++;
                }
            }
        }
        bw.write(result+" ");
        bw.flush();
        bw.close();
    }
}
