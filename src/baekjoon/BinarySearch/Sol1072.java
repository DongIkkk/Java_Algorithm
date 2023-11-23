package BinarySearch;

import java.util.Scanner;

public class Sol1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long x = sc.nextLong();
        Long y = sc.nextLong();
        Double per = (double) (100L*y/x);

        Long z = (long) Math.floor(per);

        Long start = 0L;
        Long end = x;
        Long result = Long.MAX_VALUE;
        while(start<=end){
            Long mid = (start+end)/2;

            Double perZ = (double) 100L*(y+mid)/(x+mid);
            Long tempZ = (long) Math.floor(perZ);

            if(tempZ > z){
                if(result > mid) result = mid;
                end = mid-1;
            }
            else if(tempZ <= z){
                start = mid+1;
            }
        }
        if(result == Long.MAX_VALUE) {
            result = -1L;
        }
        System.out.println(result);
    }
}
