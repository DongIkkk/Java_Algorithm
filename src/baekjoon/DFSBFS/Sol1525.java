package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol1525 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String temp = "";
        for (int i = 0; i < 3; i++) temp += br.readLine().replace(" ", "");

        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        map.put(temp, 0);
        q.add(temp);

        while(!q.isEmpty()){
            String now = q.poll();
            if(now.equals("1234567890")) break;

            int zero = now.indexOf('0');
            int zx = zero / 3;
            int zy = zero % 3;

            for (int k = 0; k < 4; k++) {
                int tx = zx + dx[k];
                int ty = zy + dy[k];

                if(tx < 0 || ty < 0 || tx >= 3 || ty >= 3) continue;

                int target = tx * 3 + ty;

                String next = now;
                next = next.replace('0', now.charAt(target));
                next = next.substring(0, target) + "0" + next.substring(target+1);

                if(!map.containsKey(next)) {
                    map.put(next, map.get(now) + 1);
                    q.add(next);
                }
            }
        }

        if(map.containsKey("123456780")) System.out.print(map.get("123456780"));
        else System.out.print(-1);
    }
}
