package D3;

import java.util.Scanner;

public class Sol7728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =1 ; tc<=T; tc++){
            int num = sc.nextInt();
            String str = String.valueOf(num);
            String[] sarr = str.split("");
            int[] nums = new int[10];
            for(String s: sarr){
                int n = Integer.parseInt(s);
                nums[n]++;
            }
            int count = 0;
            for(int nn: nums){
                if(nn!=0) count++;
            }

            System.out.printf("#%d %d\n",tc,count);

        }
    }
}
