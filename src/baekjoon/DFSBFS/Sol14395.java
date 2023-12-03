package DFSBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol14395 {
    static Queue<Object[]> q = new LinkedList<>();
    static HashSet<Long> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        Long t = sc.nextLong();

        if(s == t) {
            System.out.println(0);
            return;
        }
        q.add(new Object[] {"", s});

        while(!q.isEmpty()) {
            Object[] tempO = q.poll();
            String temps = (String) tempO[0];
            Long temp = Long.valueOf(String.valueOf(tempO[1]));
            if(temp.equals(t)) {
                System.out.println(temps);
                return;
            }

            if(!set.contains(temp*temp)){
                set.add(temp*temp);
                q.add(new Object[] {temps+"*", temp * temp});
            }
            if(!set.contains(temp+temp)){
                set.add(temp+temp);
                q.add(new Object[] {temps+"+", temp + temp});
            }
            if(!set.contains(0L)){
                set.add(0L);
                q.add(new Object[] {temps+"-", 0L});
            }

            if(temp != 0 && !set.contains(1L)){
                set.add(1L);
                q.add(new Object[] {temps+"/", 1L});
            }
        }
        System.out.println(-1);


    }
}
