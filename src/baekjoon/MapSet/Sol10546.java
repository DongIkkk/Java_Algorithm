package MapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sol10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        }
        for (int i = 0; i < N-1; i++) {
            String s = br.readLine();
            if(map.get(s) == 1) {
                map.remove(s);
            } else {
                map.put(s, map.get(s)-1);
            }
        }
        for(String s : map.keySet()) {
            System.out.println(s);
        }
    }
}
