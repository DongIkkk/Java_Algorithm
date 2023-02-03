import java.util.Scanner;

public class Sol1989 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();


        for (int tc = 1; tc <= T; tc++) {
            String palindrome = sc.nextLine();
            int len = palindrome.length();
            int ispalindrome = 1;

            for(int i=0; i<len/2; i++) {
                char front = palindrome.charAt(i);
                char end = palindrome.charAt(len-i-1);



                if (front != end) {
                    ispalindrome = 0;
                    break;
                }
            }
            System.out.printf("#%d %d\n", tc, ispalindrome);

        }
    }
}
