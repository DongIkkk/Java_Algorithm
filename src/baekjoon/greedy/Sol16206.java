package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Sol16206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cake = new int[N];
        int result = 0;

        for(int i=0; i<N; i++){
            cake[i]=sc.nextInt();
        }

        Arrays.sort(cake);


        // 10인거
        for(int a: cake){
            if(a==10) {
                result++;
            }
        }

        // 20부터 10의배수
        for(int b: cake){
            if(b%10 == 0 && b/10>=2){
                if(M == b/10-1){
                    result += b/10;
                    M=0;
                    break;
                }else if(M < b/10-1){
                    result += M;
                    M = 0;
                    break;
                }else{
                    result += b/10;
                    M -= b/10 - 1;
                    if(M==0)break;
                }
            }
        }

        outer:
        for(int c:cake){
            while(c>10 && M>0 && c%10!=0){
                c -= 10;
                M--;
                result++;
                if(M==0){
                    break outer;
                }
            }
        }

        System.out.println(result);
    }
}
