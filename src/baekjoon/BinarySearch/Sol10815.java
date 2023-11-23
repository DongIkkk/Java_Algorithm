package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n-1;

            while(start <= end) {
                int mid = (start + end) / 2;
                if(arr[mid] == temp) {
                    sb.append("1 ");
                    continue outer;
                }

                if(arr[mid] < temp) {
                    start = mid + 1;
                } else if(arr[mid] > temp) {
                    end = mid - 1;
                }
            }

            sb.append("0 ");
        }

        System.out.println(sb.toString());
    }
}
