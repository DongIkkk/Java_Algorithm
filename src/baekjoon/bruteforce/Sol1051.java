package bruteforce;

import java.util.Scanner;

public class Sol1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String in  = sc.next();
            map[i] = in.toCharArray();
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char temp = map[i][j];

                for (int k = 1; k < m-j; k++) {
                    if(temp == map[i][j+k]){
                        if(i+k < n && temp == map[i+k][j] && temp == map[i+k][j+k]){
                            int tempResult = (k+1) * (k+1);
                            result = Math.max(result, tempResult);
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}