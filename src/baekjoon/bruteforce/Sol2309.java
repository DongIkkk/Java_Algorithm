package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Sol2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum+= arr[i];
        }

        Arrays.sort(arr);
        int no1=0, no2=0;
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum - (arr[i]+arr[j]) == 100){
                    no1 = i;
                    no2 = j;
                    break;
                }
            }
        }

        for(int i=0; i<9; i++){
            if(i == no1 || i==no2) continue;
            System.out.println(arr[i]);
        }
    }
}
