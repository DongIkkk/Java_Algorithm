package D1_D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        for (int tc = 1; tc <= N; tc++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            int line = sc.nextInt();
            line -= 1;
            System.out.println("#"+tc);
            System.out.println(1);
            if (line != 0) System.out.println(list.get(0) +" "+ list.get(1));
            for (int i = 2; i <= line; i++) {
                List<Integer> templist = new ArrayList<>();
                for(int j=0; j<list.size()-1; j++){
                    templist.add(list.get(j)+list.get(j+1));
                }
                templist.add(0, 1);
                templist.add(i, 1);
                for(int num: templist){
                    System.out.print(num+" ");
                }
                System.out.println();
                list = templist;

            }

        }
    }
}
