package D3;
import java.util.Scanner;

public class Sol5601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            System.out.print("#"+tc+" ");
            for(int i=0; i<N; i++) {
                System.out.print("1/"+N+" ");
            }
            System.out.println();
        }
    }
}
