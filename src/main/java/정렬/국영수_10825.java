package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수_10825 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for(int i=0;i<total;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korean, english, math));
        }

        Comparator<Student> studentComparator = (s1, s2) -> {
            if(s1.korean !=s2.korean){
                return s2.korean - s1.korean; //국어 내림차순
            }else if(s1.english!=s2.english){
                return s1.english - s2.english; //영어 오름차순
            }else if(s1.math != s2.math){
                return s2.math - s1.math; //수학 내림차순
            }else{
                return s1.name.compareTo(s2.name);
            }
        };

        list.sort(studentComparator);
        for(Student s : list){
            bw.write(s.name);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    public static class Student{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
