package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Sol14696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        outer:
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int[] aarr = new int[a];
            for(int j=0; j<a; j++){
                aarr[j] = sc.nextInt();
            }

            int b = sc.nextInt();
            int[] barr = new int[b];
            for(int j=0; j<b; j++){
                barr[j] = sc.nextInt();
            }

            Arrays.sort(aarr);
            Arrays.sort(barr);
            int[] anew = new int[a];
            for(int j=aarr.length-1; j>=0; j--){
                anew[a-j-1] = aarr[j];
            }

            int[] bnew = new int[b];
            for(int j=barr.length-1; j>=0; j--){
                bnew[b-j-1] = barr[j];
            }

            int count = 1;
            for(int j=0; j<Math.max(a,b); j++){
                if(anew[j]>bnew[j]) {
                    System.out.println("A");
                    continue outer;
                }
                else if(anew[j]<bnew[j]){
                    System.out.println("B");
                    continue outer;
                }


                if(a<b && count == a){
                    System.out.println("B");
                    continue outer;
                } else if(a>b && count == b){
                    System.out.println("A");
                    continue outer;
                }
                count++;



            }
            System.out.println("D");
        }
    }
}
