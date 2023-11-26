package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lectures = new int[n];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            if(lectures[i] > max) max = lectures[i];
        }

        int start = max;
        int end = sum;

        while(start <= end) {
            int mid = (start + end) / 2;

            int tempSum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if( tempSum + lectures[i] > mid) {
                    tempSum = 0;
                    count++;
                }

                tempSum += lectures[i];
            }
            if(tempSum != 0){
                count++;
            }
            if(count > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(start);
    }
}
