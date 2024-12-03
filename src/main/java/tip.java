import java.io.*;
import java.util.*;

public class tip {
    //알고리즘 공부를 하며 유용하게 사용한 메서드들
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        // 1. Arrays.fill
//        // 배열을 같은 값으로 한번에 채울 때 유용하다(1차원 배열에서만 가능)
//        int[] arr1 = new int[5];
//        Arrays.fill(arr1, 0);
//
//        for (int ints : arr1) {
//            bw.write(String.valueOf(ints));
//        }
//        bw.flush();
//        bw.close();

        // 2. TreeMap
        // 트리맵에 객체를 저장하면 키가 저장과 동시에 오름차순으로 정렬된다.
        // 따라서 정렬된 데이터를 조회해야 하는 범위검색이 필요한 경우나 정렬된 상태로 배열을 유지해야 하는 경우 유용하다.
//        String[] words = new String[]{"july", "apple", "banana", "rocket", "mango"};
//        int[] nums = new int[]{1,2,3,4,5};
//        Map<String, Integer> hashMap = new HashMap<>();
//        Map<String, Integer> treeMap = new TreeMap<>();
//        for(int i=0;i< words.length;i++){
//            hashMap.put(words[i],nums[i]);
//            treeMap.put(words[i],nums[i]);
//        }
//
//        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
//            bw.write(stringIntegerEntry.toString());
//            bw.newLine();
//        }
//        bw.write("----------------");
//        bw.newLine();
//        for (Map.Entry<String, Integer> stringIntegerEntry : treeMap.entrySet()) {
//            bw.write(stringIntegerEntry.toString());
//            bw.newLine();
//        }
//        bw.flush();
//        bw.close();

        //3. String.join
        //자바11부터 사용할 수 있다.
        //String.join("구분기호", 문자열) 의 형태로, 구분 기호를 사용하여 문자열을 연결 할 수 있다.
//        String[] strlist = new String[]{"aaa","bbb","ccc","ddd"};
//        String a = "aaa";
//        String b = "bbb";
//        String c = "ccc";
//        String word1 = String.join("*",strlist);
//        String word2 = String.join("@",a,b,c);
//
//        bw.write(word1);
//        bw.newLine();
//        bw.write(word2);
//        //결과값 :
//        //aaa*bbb*ccc*ddd
//        //aaa@bbb@ccc
//        bw.flush();
//        bw.close();

        //4. PriorityQueue에서 Map을 정렬해야 할 때
        // PriorityQueue는 Map 자체를 정렬할 수 없기 때문에 Map.Entry 객체를 제네릭으로 받아서 삽입하는데,
        // 이렇게 만든 우선순위 큐에 데이터를 삽입하려면 별도의 클래스 정의가 필요하다.
        // 먼저 클래스를 정의하고
//        class University {
//            String name; // 대학 이름
//            int score;   // 점수
//
//            // 생성자
//            public University(String name, int score) {
//                this.name = name;
//                this.score = score;
//            }
//        }
//
//        //이렇게 사용한다.
//        PriorityQueue<University> queue = new PriorityQueue<>();
//        // 데이터 삽입
//        queue.add(new University("Harvard", 95));

        //이 때, 클래스를 정의하지 않고 SimpleEntry를 이용해서 더 간단하게 표현할 수 있다.
        //AbstractMap.SimpleEntry<K, V>는 자바에서 제공하는 간단한 키-값 쌍 표현 클래스이다.
        //queue.add(new AbstractMap.SimpleEntry<>(st.nextToken(), Integer.parseInt(st.nextToken())));
        //이렇게 사용하면 간단하고 깔끔하게 데이터 쌍 관리가 가능하다.
        // 단, 이 클래스가 다른 곳에서도 재사용된다면 클래스로 정의해서 관리하는 게 낫다.




    }
}
