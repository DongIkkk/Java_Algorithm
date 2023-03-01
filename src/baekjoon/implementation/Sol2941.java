package implementation;

import java.util.Scanner;

public class Sol2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] sarr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String cro : sarr) {
            s = s.replace(cro, "1");
        }
        System.out.println(s.length());
    }
}
