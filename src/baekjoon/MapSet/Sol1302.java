package MapSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String in = st.nextToken();

            if(map.containsKey(in)){
              int count = map.get(in);
              map.put(in, count+1);
            } else {
                map.put(in, 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        int max = 0;
        String result = "";
        for(String key: keySet) {
            if(map.get(key) > max) {
                max = map.get(key);
                result = key;
            }
        }

        System.out.println(result);

    }
}
