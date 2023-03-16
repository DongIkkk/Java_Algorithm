package implementation;

import java.util.Scanner;

public class Sol1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[10];

        String s = sc.next();
        char[] carr = s.toCharArray();
        int n=0;
        for(char c: carr){
            if(c=='6' || c=='9'){
                if(count[6]!=count[9]) count[9]++;
                else count[6]++;
            } else{
                n = c - '0';
                count[n]++;
            }
        }
        int max = -1;
        for(int num : count){
            if(max<num) max = num;
        }
        System.out.println(max);
    }
}
