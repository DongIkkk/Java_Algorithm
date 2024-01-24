package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sol11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int nc = 0;
        int mc = 0;

        StringBuilder sb = new StringBuilder();
        while(true) {
            if (nc == N && mc == M) {
                break;
            } else if(nc == N) {
                while(mc<M) {
                    sb.append(arr2[mc++]);
                    sb.append(" ");
                }
                break;
            } else if(mc == M) {
                while(nc<N) {
                    sb.append(arr1[nc++]);
                    sb.append(" ");
                }
                break;
            }

            if(arr1[nc] > arr2[mc]) {
                sb.append(arr2[mc++]);
                sb.append(" ");
            } else {
                sb.append(arr1[nc++]);
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
