package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sol25206 {
//    A+	4.5
//    A0	4.0
//    B+	3.5
//    B0	3.0
//    C+	2.5
//    C0	2.0
//    D+	1.5
//    D0	1.0
//    F	0.0
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Float> grade = new HashMap<>();

        grade.put("A+", 4.5f);
        grade.put("A0", 4.0f);
        grade.put("B+", 3.5f);
        grade.put("B0", 3.0f);
        grade.put("C+", 2.5f);
        grade.put("C0", 2.0f);
        grade.put("D+", 1.5f);
        grade.put("D0", 1.0f);
        grade.put("F", 0.0f);

        float gradeSum = 0.0f;
        float scoreSum = 0.0f;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String trash = st.nextToken();
            float zzz = Float.valueOf(st.nextToken());
            gradeSum += zzz;
            String sub = st.nextToken();
            if(sub.equals("P")) {
                gradeSum -= zzz;
                continue;
            }
            float xxx = grade.get(sub);
            scoreSum += zzz * xxx;

        }
        System.out.println(scoreSum / gradeSum);
    }
}
