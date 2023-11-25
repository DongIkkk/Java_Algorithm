package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dep = new int[n];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dep[i] = Integer.parseInt(st.nextToken());
            sum += dep[i];
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        Arrays.sort(dep);
        int max = dep[n-1];

        if(sum <= m) {
            System.out.println(max);
            return;
        }

        int start = 1;
        int end = max-1;
        while(start <= end) {
            int mid = (start + end) / 2;

            int tempSum = 0;
            for (int i = 0; i < n; i++) {
                tempSum += Math.min(dep[i], mid);
            }

            if(tempSum > m){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        System.out.println(start-1);

    }
}








