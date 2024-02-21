package sort;

import java.util.*;
import java.io.*;

public class Sol1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> pBook = new ArrayList<>();
        ArrayList<Integer> nBook = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(input > 0) pBook.add(input);
            else nBook.add(input);
        }

        pBook.sort(Collections.reverseOrder());
        Collections.sort(nBook);

        int result = 0;
        int end = Integer.MIN_VALUE;

        // 양수
        int count = 0;
        int temp = 0;
        for(int n: pBook) {
            if(count==0) {
                temp = n;
                end = Math.max(end, temp);
            }

            if(++count == M) {
                result += temp * 2;
                count = 0;
                temp = 0;
            }
        }
        result += temp*2;

        // 음수
        count = 0;
        temp = 0;
        for(int n: nBook) {
            if(count == 0) {
                temp = Math.abs(n);
                end = Math.max(end, temp);
            }

            if(++count == M) {
                result += temp * 2;
                count = 0;
                temp = 0;
            }
        }
        result += temp*2;

        System.out.println(result - end);
    }
}
