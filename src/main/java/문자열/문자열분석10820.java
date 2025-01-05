package 문자열;
import java.io.*;
public class 문자열분석10820 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = "";

        while ((word = br.readLine())!=null){
            int upper = 0;
            int lower = 0;
            int num = 0;
            int blank = 0;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(Character.isUpperCase(c)){
                    upper++;
                } else if (Character.isLowerCase(c)) {
                    lower++;
                } else if(Character.isDigit(c)){
                    num++;
                }else{
                    blank++;
                }
            }
            bw.write(lower+" "+upper+" "+num+" "+blank);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
