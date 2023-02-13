package D1_D2;

import java.util.Arrays;
import java.util.Scanner;

public class Sol1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i<=N; i++){
            String num = Integer.toString(i);
            String[] arr = num.split("");
            int is369 = 0;
            if(Arrays.asList(arr).contains("3") || Arrays.asList(arr).contains("6") ||Arrays.asList(arr).contains("9")){
                is369 = 1;
            }
            if(is369 == 0){
                System.out.print(i);
            } else {
                for(String s:arr){
                    if(s.equals("3") || s.equals("6") || s.equals("9")){
                        System.out.print("-");
                    }
                }
            }

            System.out.print(" ");
        }
    }
}
