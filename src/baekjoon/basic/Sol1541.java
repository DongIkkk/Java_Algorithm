package basic;

import java.util.Scanner;

public class Sol1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String in = sc.next();

        String[] arr = in.split("-");
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            String[] temparr = temp.split("\\+");
            if(i==0) {
                int ttt = 0;
                for (int j = 0; j < temparr.length; j++) {
                    ttt += Integer.parseInt(temparr[j]);
                }
                result += ttt;
            }else {
                int ttt = 0;
                for (int j = 0; j < temparr.length; j++) {
                    ttt += Integer.parseInt(temparr[j]);
                }
                result -= ttt;
            }
        }
        System.out.println(result);
    }
}
