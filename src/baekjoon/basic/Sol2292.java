package basic;

import java.util.Scanner;

public class Sol2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int layer = 1;
        int num = 1;
        while(true){
            if(N <= num){
                break;
            }
            num = num + (layer * 6);
            layer++;
        }
        System.out.println(layer);
    }
}
