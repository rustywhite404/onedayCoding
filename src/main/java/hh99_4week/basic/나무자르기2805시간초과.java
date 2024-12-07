package hh99_4week.basic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 입력 :
 * - 나무의 수 N, 집으로 가져가고 싶은 길이 M
 * - 각 나무들의 높이 N개
 *
 * 연산 :
 * - 설정한 높이 H 이상의 높이들이 다 잘림
 * - 높이를 제일 높은 나무 높이-1부터 시작함.
 * - 각 나무에서 자른 수들을 다 더했을 때 M과 같거나 커야함.
 *
 * 출력 :
 * - 최소 M미터의 나무를 가져가려면 절단기에 설정해야 하는 값 H 출력
 * */
public class 나무자르기2805시간초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeAmount = Integer.parseInt(st.nextToken());
        long hopeAmount = Long.parseLong(st.nextToken());
        long currentAmount = 0;
        int[] treeList = new int[treeAmount];
        st = new StringTokenizer(br.readLine());

        //나무 세팅
        for(int i=0;i<treeAmount;i++){
            treeList[i] = Integer.parseInt(st.nextToken());
        }

        //나무 크기순 정렬
        Arrays.sort(treeList);

        //자르기 시작할 높이 = 나무 최대 높이 -1
        int cutHeight = treeList[treeList.length-1]-1;

        while (hopeAmount>currentAmount){ //희망 미터수가 현재 자른 미터수보다 클 동안

            for(int i=0;i<treeAmount;i++){
                //나무를 자르기 시작할 높이보다 현재 나무가 높으면
                int currentTreeHeight = treeList[i];
                if(cutHeight<currentTreeHeight){
                    treeList[i] -= (currentTreeHeight-cutHeight);
                    currentAmount += (currentTreeHeight-cutHeight);
                }
                if(hopeAmount<currentAmount) break; //도중에라도 희망 미터수를 채우면 더이상 반복하지 않고 나옴
            }
            //다 잘랐는데 아직 희망 미터수가 더 크면
            if(hopeAmount>currentAmount){
                cutHeight--; //1미터 더 아래까지 잘라봄
            }
        }

        bw.write(cutHeight+" ");
        bw.flush();
        bw.close();
    }
}
