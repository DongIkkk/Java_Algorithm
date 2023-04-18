package DFSBFS;

import java.util.*;

public class Sol16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] map = new int[101];
        Arrays.fill(map, 98765);
        int[] ladderSnake = new int[101];
        int from = 0;
        int to = 0;

        for (int i = 0; i < n+m; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            ladderSnake[from] = to;
        }

        map[1]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(q.size()!=0){
            int now = q.poll();
            for(int i=1; i<=6; i++){
                if(now+i <= 100){
                    if(ladderSnake[now+i]>0){
                        if(map[ladderSnake[now+i]] > map[now] + 1){
                            map[ladderSnake[now + i]] = map[now] + 1;
                            q.add(ladderSnake[now + i]);
                        }
                    } else if(map[now+i] > map[now] + 1){
                        map[now+i] = map[now] + 1;
                        q.add(now+i);
                    }

                }
            }
        }
        System.out.println(map[100]);
    }
}
