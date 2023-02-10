package basic;

import java.util.Scanner;

public class Sol2609 {
    public static void main(String[] args) {
        //최대공약수와 최소공배수 구하기
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        //최대공약수
        int count = x;
        while(count>=1){
            if(x%count==0 && y%count==0) break;
            count--;
        }
        System.out.println(count);

        //최소공배수
        int temp = y;
        int i = 1;
        while(i<=x){
            if(y%x==0)break;
            y += temp;
            i++;
        }
        System.out.println(temp*i);
    }
}
