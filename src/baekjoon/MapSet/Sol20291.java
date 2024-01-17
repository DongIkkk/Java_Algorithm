package MapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Sol20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            String in = s.split("\\.")[1];

            if(map.containsKey(in)) {
                map.put(in, map.get(in)+1);
            } else {
                map.put(in, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : map.keySet()) {
            sb.append(s + " ");
            sb.append(map.get(s));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
