package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        long max = 0;
        long min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(max<trees[i]) max = trees[i];
        }

        long h =0;

        while(min<=max){
            h = (max+min) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(h<trees[i]){
                    sum += trees[i] - h;
                }
            }

            if(sum >= m){
                min = h+1;
            } else {
                max = h-1;
            }

        }

        System.out.println(max);
    }
}
