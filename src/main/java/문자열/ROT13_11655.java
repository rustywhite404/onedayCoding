package 문자열;

import java.io.*;
public class ROT13_11655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        String[] newWord = new String[word.length()];

        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);
            if(Character.isDigit(current)){
                newWord[i] = String.valueOf(current);
            } else if (Character.isLowerCase(current)) {
                current = (char) (current + 13);
                if(current>='a'+26){
                    int num = current-26;
                    current = (char) num;
                }
                newWord[i] = String.valueOf(current);
            } else if (Character.isUpperCase(current)) {
                current = (char) (current + 13);
                if(current>='A'+26){
                    int num = current-26;
                    current = (char) num;
                }
                newWord[i] = String.valueOf(current);
            }else {
                newWord[i] = " ";
            }
        }

        for (String s : newWord) {
            bw.write(s);
        }
        bw.flush();
        bw.close();
    }
}
