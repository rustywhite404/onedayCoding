package 정렬;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 두 점(출발, 도착)이 주어진다.
 * 여러 개의 원이 있고, 각 원은 중심과 반지름으로 정의된다.
 * 이 두 점이 주어진 원들의 내부에 들어갔다가 나오는지 판단해야 한다.
 * => 한 원의 내부에 출발지나 도착지 중 하나만 있으면 그 원을 한 번 지나는 것.
 * 점 (x, y)가 원(cx, cy, r) 안에 있는지 확인하려면
 * (x-cx)^2 + (y-cy)^2 < r^2 이면 내부에 있음.
 * */
public class 어린왕자1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int planetAmount = Integer.parseInt(br.readLine());
            for (int j = 0; j < planetAmount; j++) {
                st = new StringTokenizer(br.readLine());
                int planetX = Integer.parseInt(st.nextToken());
                int planetY = Integer.parseInt(st.nextToken());
                int halfWidth = Integer.parseInt(st.nextToken());

                boolean startInside = isInsideCircle(startX, startY, planetX, planetY, halfWidth);
                boolean endInside = isInsideCircle(endX, endY, planetX, planetY, halfWidth);

                if(startInside != endInside){
                    result++;
                }

            }
            bw.write(result+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static boolean isInsideCircle(int x, int y, int cx, int cy, int r){
        return Math.pow((x - cx), 2) + Math.pow((y - cy), 2) < Math.pow(r, 2);
    }
}
