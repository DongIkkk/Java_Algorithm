package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol2806 {
    static int n;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            n = sc.nextInt();
            List<Integer>[] map = new List[n];
            for (int i = 0; i < n; i++) {
                map[i] = new ArrayList<>();
            }
            count = 0;
            queen(0, map);
            System.out.printf("#%d %d\n",tc,count);
        }
    }

    public static void queen(int row, List<Integer>[] map){

        for (int i = 0; i < n; i++) {
            if(!map[row].contains(i)){
                if(row==n-1) {
                    count++;
                    return;
                }
                List<Integer>[] map2 = new List[n];
                for (int m = 0; m < n; m++) {
                    map2[m] = new ArrayList<>(map[m]);
                }
                map2[row].add(i);
                int next = 1;
                for(int j=row+1; j<n; j++){
                    map2[j].add(i);
                    map2[j].add(i+next);
                    map2[j].add(i-next);
                    next++;
                }
                queen(row+1, map2);

            }
        }


    }
}
