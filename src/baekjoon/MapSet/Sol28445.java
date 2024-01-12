package MapSet;

import java.util.Scanner;
import java.util.TreeSet;

public class Sol28445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<String> color = new TreeSet<>();

        for (int i = 0; i < 4; i++) {
            color.add(sc.next());
        }

        for(String s: color) {
            for(String ss: color) {
                System.out.printf("%s %s\n", s, ss);
            }
        }

    }
}
