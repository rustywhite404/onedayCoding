package level06;

import java.io.*;
import java.util.StringTokenizer;

public class solve25206 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double 학점 = 0;
        double 전공과목별합계 = 0;
        double 총학점 = 0;
        for(int i=0;i<20;i++){
            st = new StringTokenizer(br.readLine()," ");
            String subject = st.nextToken();
            학점 = Double.parseDouble(st.nextToken());
            String 등급 = st.nextToken();
            double 등급별점수 = 0;

            //p등급은 계산에서 제외
            if(등급.equals("P")){
                continue;
            }
            switch (등급){
                case "A+" :
                    등급별점수 = 4.5;
                    break;
                case "A0" :
                    등급별점수 = 4.0;
                    break;
                case "B+" :
                    등급별점수 = 3.5;
                    break;
                case "B0" :
                    등급별점수 = 3.0;
                    break;
                case "C+" :
                    등급별점수 = 2.5;
                    break;
                case "C0" :
                    등급별점수 = 2.0;
                    break;
                case "D+" :
                    등급별점수 = 1.5;
                    break;
                case "D0" :
                    등급별점수 = 1.0;
                    break;
                case "F" :
                    등급별점수 = 0.0;
                    break;
            }
            총학점 += 학점;
            전공과목별합계 += 학점*등급별점수;
        }
        double 전공평점 = (전공과목별합계 / 총학점) ;
        bw.write(String.format("%.6f", 전공평점));
        bw.flush();
        bw.close();
    }

}
