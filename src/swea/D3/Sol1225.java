package D3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc<=10; tc++) {
            int N = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();

            for(int i=0; i<8; i++) {
                q.add(sc.nextInt());
            }
            int temp=0;
            int count=1;
            while(true) {
                if(count == 6) count=1;
                temp = q.remove()-count;
                count++;

                if(temp<=0) {
                    temp=0;
                    q.add(temp);
                    break;
                }else {
                    q.add(temp);
                }
            }
            System.out.printf("#%d %d %d %d %d %d %d %d %d\n",tc,q.remove(),q.remove(),q.remove(),q.remove(),q.remove(),q.remove(),q.remove(),q.remove());
        }
    }
}
