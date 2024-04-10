package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol14888 {
    static int N;
    static int[] arr;
    static int[] op = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        gogo(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void gogo(int num, int count) {
        if(count == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        gogo(num + arr[count], count + 1);
                        break;
                    case 1:
                        gogo(num - arr[count], count + 1);
                        break;
                    case 2:
                        gogo(num * arr[count], count + 1);
                        break;
                    case 3:
                        gogo(num / arr[count], count + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}
