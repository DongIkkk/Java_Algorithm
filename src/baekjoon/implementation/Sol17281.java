package implementation;

import java.io.*;
import java.util.*;

public class Sol17281 {
    static int N;
    static int[] hitter = new int[10];
    static boolean[] visited = new boolean[10];
    static int[][] score;
    static boolean[] base = new boolean[3];
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        score = new int[N][10];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        hitter[4] = 1;
        visited[1] = true;
        gogo(1);

        System.out.println(result);
    }

    private static void gogo(int count) {
        if(count == 4) count++;

        if(count == 10) {
            calScore(hitter);
            return;
        }

        for (int i = 2; i < 10; i++) {
            if(!visited[i]){
                hitter[count] = i;
                visited[i] = true;
                gogo(count+1);
                visited[i] = false;
            }
        }

    }

    private static void calScore(int[] order) {
        int now = 1;
        int out, shot, totalScore=0;

        Inning:
        for (int i = 0; i < N; i++) {
            out = 0;
            base = new boolean[3];

            while(true) {
                shot = score[i][order[now]];
                now++;
                if(now == 10) now = 1;
                switch (shot) {
                    case 0:
                        if(++out == 3) {
                            continue Inning;
                        }
                        break;
                    case 1:
                        if(base[2]) totalScore++;
                        base[2] = base[1];
                        base[1] = base[0];
                        base[0] = true;
                        break;
                    case 2:
                        if(base[2]) totalScore++;
                        if(base[1]) totalScore++;
                        base[2] = base[0];
                        base[1] = true;
                        base[0] = false;
                        break;
                    case 3:
                        if(base[2]) totalScore++;
                        if(base[1]) totalScore++;
                        if(base[0]) totalScore++;
                        base[2] = true;
                        base[1] = false;
                        base[0] = false;
                        break;
                    case 4:
                        if(base[2]) totalScore++;
                        if(base[1]) totalScore++;
                        if(base[0]) totalScore++;
                        totalScore++;
                        base[2] = false;
                        base[1] = false;
                        base[0] = false;
                        break;
                }
            }
        }

        result = Math.max(totalScore, result);
    }
}
