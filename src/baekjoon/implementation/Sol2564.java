package implementation;

import java.util.Scanner;

public class Sol2564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int shop = sc.nextInt();
        int[] shops = new int[shop];

        int a, b;

        for(int i=0; i<shop; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if(a==1) {
                shops[i] = (r+c)*2 -b;
            }
            if(a==2) {
                shops[i] = c+b;
            }
            if(a==3) {
                shops[i] = b;
            }
            if(a==4) {
                shops[i] = (r+c)*2-b-r;
            }
        }

        int dong0 = sc.nextInt();
        int dong1 = sc.nextInt();
        int dong=0;
        if(dong0==1) {
            dong = (r+c)*2 -dong1;
        }
        if(dong0==2) {
            dong = c+dong1;
        }
        if(dong0==3) {
            dong = dong1;
        }
        if(dong0==4) {
            dong = (r+c)*2-dong1-r;
        }

        int sum=0;
        for(int n:shops) {
            int dis=0;
            if((int)Math.abs(dong-n) > (r+c)) {
                dis = (r+c)*2 - (int)Math.abs(dong-n);
            }else {
                dis = (int)Math.abs(dong-n);
            }
            sum += dis;
        }

        System.out.println(sum);


    }
}
