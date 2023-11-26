package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] home = new int[n];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            home[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(home);

        int start = 1;
        int end = home[n-1];

        while(start <= end) {
            int mid = (start + end) / 2;

            int gong = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                if(home[i] - home[gong] >= mid){
                    gong = i;
                    count++;
                }
            }

            if(count < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
    }
}
