package basic;

import java.util.Arrays;
import java.util.Scanner;

// 직각 삼각형
public class Sol4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int x, y, z;
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            if(x==0 && y==0 && z==0) break;

            int[] arr = {x,y,z};
            int temp = 0;
            for (int i = 0; i < 2; i++) {
                temp = 0;
                if(arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            int c = arr[2] * arr[2];
            int a = arr[1] * arr[1];
            int b = arr[0] * arr[0];

            if(c == (a+b)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }

        }

    }
}
