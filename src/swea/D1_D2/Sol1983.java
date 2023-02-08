package D1_D2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 조교의 성적 매기기
public class Sol1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] grarr = {null, "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};


        for (int tc=0; tc<T; tc++){
            int check=0;
            int N = sc.nextInt();
            int K = sc.nextInt();
            ArrayList<Integer> score = new ArrayList();
            for (int i=0; i<N; i++){
                int sum = 0;
                int input = sc.nextInt();
                sum += input * 35;
                int input2 = sc.nextInt();
                sum += input2 * 45;
                int input3 = sc.nextInt();
                sum += input3 * 20;
                score.add(sum);
                if(i==K-1) check=sum;
            }

            score.sort(Comparator.naturalOrder());
            int kindex = score.indexOf(check) + 1;
            int rate = N / 10;
            int grade = (int) Math.ceil(kindex / (double)rate);
            System.out.println("#"+(tc+1)+" "+grarr[grade]);

        }


    }
}
