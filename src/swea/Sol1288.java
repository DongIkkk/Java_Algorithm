import java.util.HashSet;
import java.util.Scanner;

public class Sol1288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int tc = 1; tc <= N ; tc++) {
            int x = sc.nextInt();
            int plus = x;
            HashSet<String> set = new HashSet<String>();

            while(set.size()<=9){
                String str = String.valueOf(x);
                String[] spl = str.split("");
                for(String s: spl){
                    set.add(s);
                }
                if(set.size()==10) break;
                x += plus;

            }
            System.out.printf("#%d %d\n", tc, x);

        }
    }
}
