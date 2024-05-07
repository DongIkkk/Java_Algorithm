package backTracking;

import java.io.*;

public class Sol10597 {
    static String S;
    static boolean end;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        N = S.length() >= 9 ? 9 + (S.length() - 9) / 2 : S.length();
        visited = new boolean[N+1];
        visited[0] = true;
        gogo(0, "");
    }

    static public void gogo(int index, String result) {
        if(end) return;
        if(index >= S.length()) {
            System.out.println(result.substring(1));
            end = true;
            return;
        }

        int now = Integer.parseInt(S.substring(index, index+1));
        if(now == 0) return;
        if(!visited[now]) {
            visited[now] = true;
            gogo(index+1, result + " " + now);
            visited[now] = false;
        }

        if(index+2 > S.length()) return;
        now = Integer.parseInt(S.substring(index, index+2));
        if(now > N) return;
        if(!visited[now]) {
            visited[now] = true;
            gogo(index+2, result + " " + now);
            visited[now] = false;
        }
    }
}
