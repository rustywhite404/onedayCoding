package hh99_4week.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전이진트리9934 {
    /*
    * 중위 순회를 하는 완전이진트리가 주어진다.
    * 이 트리를 재귀를 사용해 각 레벨의 노드를 구한다.
    * */
    static List<List<Integer>> levels; //각 레벨 별 노드 저장 리스트
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int treeDepth = Integer.parseInt(br.readLine()); // 트리의 깊이
        int totalNodes = (int)Math.pow(2, treeDepth)-1; //총 노드 갯수 2^treeDepth-1

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 0;

        //중위순회 결과 입력
        List<Integer> inputNodes = new ArrayList<>();
        while (st.hasMoreTokens()){
            inputNodes.add(Integer.parseInt(st.nextToken()));
        }

        //입력받은 리스트에 맞춰서 중위 순회 배열 생성
        int[] inorder = new int[inputNodes.size()];
        for(int i=0;i<inputNodes.size();i++){
            inorder[i] = inputNodes.get(i);
        }

        //각 레벨 별 노드를 저장할 리스트 초기화
        levels = new ArrayList<>();
        for(int i=0;i<treeDepth;i++){
            levels.add(new ArrayList<>());
        }

        //트리를 재귀적으로 복원하며 레벨 별 노드 구성
        buildTree(inorder, 0, totalNodes-1,0);
        // 중위 순회 결과 배열 ex. [1,6,4,3,5,2,7] / 현재 처리중인 배열 범위의 시작 인덱스 / 현재 배열 범위의 끝 인덱스 / 현재 트리의 깊이(레벨)

        //레벨 별로 출력
        for(List<Integer> level:levels){
            for (int node : level) {
                bw.write(node + " ");
            }
            bw.newLine();
        }
        bw.flush();

    }

    private static void buildTree(int[] inorder, int start, int end, int currentDepth) {
        if(start>end){ //더이상 노드가 없으면 종료
            return;
        }

        //현재 배열 범위에서 중간값이 루트 노드
        int mid = (start+end)/2;
        levels.get(currentDepth).add(inorder[mid]); //해당 레벨에 노드 추가

        // 왼쪽 서브트리와 오른쪽 서브트리로 재귀 호출

        buildTree(inorder, start, mid-1, currentDepth+1); //왼쪽 서브트리
        buildTree(inorder, mid + 1, end, currentDepth + 1); //오른쪽 서브트리

    }
}
