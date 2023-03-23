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

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(max<trees[i]) max = trees[i];
            if(min>trees[i]) min = trees[i];
        }

        int h = (max+min) / 2;

        while(true){

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(h<trees[i]){
                    sum += trees[i] - h;
                }
            }
            if (sum == m) {
                break;
            } else if(sum > m){
                min = h;
                h = (max+min) / 2 + 1;
            } else {
                max = h;
                h = (max+min) / 2;
            }

            if(min>=max) break;
        }

        System.out.println(h);
    }
}
