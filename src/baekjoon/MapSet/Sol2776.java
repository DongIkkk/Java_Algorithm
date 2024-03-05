package MapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Sol2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
            System.out.print(sb);
        }

    }
}
