package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K번째_수_11004 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int total = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        int[] arr = new int[total];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<total;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bw.write(arr[index-1]+" ");
        bw.flush();
        bw.close();
    }
}
