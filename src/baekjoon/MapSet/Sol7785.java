package MapSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String zz = sc.next();
            if(zz.equals("enter")){
                set.add(s);
            } else{
                set.remove(s);
            }
        }
        String[] result = new String[set.size()];
        int idx = 0;
        for (String ss : set){
            result[idx++] = ss;
        }
        Arrays.sort(result);
        for (int i = result.length-1; i >= 0 ; i--) {
            System.out.println(result[i]);
        }
    }
}
