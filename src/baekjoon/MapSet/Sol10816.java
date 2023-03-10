package MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sol10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> base = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int in=0;
        for (int i = 0; i < N; i++) {
            in = sc.nextInt();
            if(base.containsKey(in)){
                base.put(in, base.get(in)+1);
            }else{
                base.put(in, 1);
            }
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            in = sc.nextInt();
            if(base.containsKey(in)){
                sb.append(base.get(in));
                sb.append(" ");
            }else{
                sb.append(0);
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
