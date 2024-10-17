package level06;

import java.io.*;

public class solve1316 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordCount = Integer.parseInt(br.readLine()); //단어 개수
        int groupWordCount = 0; //그룹단어 수

        for(int i=0;i<wordCount;i++){
            String word = br.readLine();
            if(isGroupWord(word)){ //그룹단어이면 카운트 증가
                groupWordCount++;
            }
        }
        bw.write(String.valueOf(groupWordCount));
        bw.flush();
        bw.close();

    }

    public static boolean isGroupWord(String word){
        boolean[] visited = new boolean[26]; //각 알파벳 방문여부 확인
        char prevChar = '\0';

        for(int j=0;j<word.length();j++){
            char currentChar = word.charAt(j);

            //현재 문자와 앞 문자가 다르고, 이미 체크한 적 있다면 그룹 단어X
            if(currentChar!=prevChar){
                if(visited[currentChar-'a']){
                    return false;
                }
                visited[currentChar-'a']=true; //현재 문자 방문 체크
            }
            prevChar = currentChar; //현재 문자를 이전 문자로 업데이트
        }
        return true;//그룹 단어인 경우 true 반환
    }
}
