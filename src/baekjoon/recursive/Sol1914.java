package recursive;

import java.math.BigInteger;
import java.util.Scanner;

public class Sol1914 {
    static StringBuilder sb = new StringBuilder();
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N<=20){
            hanoi(N,1, 2, 3);

            System.out.println(count);
            System.out.print(sb.toString());
        } else{
            BigInteger count = new BigInteger("2");
            System.out.println(count.pow(N).subtract(new BigInteger("1")));

        }

    }
    public static void hanoi(int N, int start, int mid, int end){
        if(N==1) {
            sb.append(start);
            sb.append(" ");
            sb.append(end);
            sb.append("\n");
            count++;
            return;
        }

        hanoi(N-1, start, end, mid);
        sb.append(start);
        sb.append(" ");
        sb.append(end);
        sb.append("\n");
        count++;
        hanoi(N-1, mid, start, end);
    }

}
