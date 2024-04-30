package MapSet;

import java.io.*;
import java.util.*;

public class Sol16499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            Arrays.sort(temp);
            StringBuilder sb = new StringBuilder();
            for(String s:temp) sb.append(s);
            set.add(sb.toString());
        }

        System.out.print(set.size());
    }
}
