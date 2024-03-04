package BinarySearch;

import java.util.Scanner;

public class Sol2417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long start = 0L;
        long end = N;

        long result = 0L;
        while(start <= end) {
            long mid = (start + end) / 2;

            if(N <= ((double)mid * (double)mid)) {
                result = mid;
                end = mid-1L;
            } else {
                start = mid + 1L;
            }
        }

        System.out.println(result);

    }
}
