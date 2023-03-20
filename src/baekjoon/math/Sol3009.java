package math;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> setx = new HashSet<>();
        Set<Integer> sety = new HashSet<>();


        for(int i=0; i<3; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(setx.contains(x)) setx.remove(x);
            else setx.add(x);

            if(sety.contains(y)) sety.remove(y);
            else sety.add(y);
        }

        System.out.println(setx.iterator().next()+" "+sety.iterator().next());


    }
}
