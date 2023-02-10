package basic;

import java.util.Scanner;

public class Sol1085 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x, y, w, h;
        x=sc.nextInt();
        y=sc.nextInt();
        w=sc.nextInt();
        h=sc.nextInt();
        int xmin = x, ymin = y;
        if ((w-x) < x) xmin=w-x;
        if ((h-y) < y) ymin=h-y;
        System.out.print(Math.min(xmin,ymin));

    }
}
