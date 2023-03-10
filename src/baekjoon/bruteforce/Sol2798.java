package bruteforce;

import java.util.Scanner;

public class Sol2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int max = -1;
        for( int i=0; i<N;i++){
            for(int j=i+1; j<N; j++){
                for(int k=j+1; k<N; k++){
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum<=M && max<sum) max=sum;
                }
            }
        }

        System.out.println(max);
    }
}
