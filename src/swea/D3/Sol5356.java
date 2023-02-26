package D3;

import java.util.Scanner;

public class Sol5356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            char[][] map = new char[5][];
            String s;
            int max = -1;
            for(int i=0; i<5; i++) {
                s = sc.next();
                if(s.length()>max) max = s.length();
                map[i] = s.toCharArray();
            }

            System.out.printf("#%d ",tc);
            for(int i=0; i<max; i++) {
                for(int j=0; j<5; j++) {
                    try {
                        System.out.print(map[j][i]);
                    } catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }

                }
            }
            System.out.println();
        }
    }
}
