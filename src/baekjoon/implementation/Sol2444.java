package implementation;

import java.util.Scanner;

public class Sol2444 {
    public static void main(String[] args) {
//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<2*N-1; i++){

            //공백
            for(int j=0; j<Math.abs(N-1-i); j++){
                System.out.print(" ");
            }

            //반갈라서 앞쪽
            // 0 1 2 3 4 5 6 5 4 3 2 1
            if(i<N){
                for(int j=0; j<i; j++){
                    System.out.print("*");
                }
            }else{
                for(int j=0; j<Math.abs(N+(N-2)-i); j++){
                    System.out.print("*");
                }
            }

            //중간
            System.out.print("*");

            if(i<N){
                for(int j=0; j<i; j++){
                    System.out.print("*");
                }
            }else{
                for(int j=0; j<Math.abs(N+(N-2)-i); j++){
                    System.out.print("*");
                }
            }

            System.out.println();
        }

    }
}
