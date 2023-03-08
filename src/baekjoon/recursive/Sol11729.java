package recursive;

import java.util.Scanner;

public class Sol11729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = 0;
        if(N%2==1) x=3;
        else x=2;
        hanoi(N,1, x);

    }
    public static void hanoi(int N, int start, int end){



    }
}
