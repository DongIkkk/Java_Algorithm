package DFSBFS;

import java.util.*;

public class Sol13549 {
    static int N, K;
    static Queue<int[]> q = new LinkedList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Arrays.fill(visited, 999999999);
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        pq.add(new int[] {N, 0});
        visited[N] = 0;

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
//            System.out.println(now[0]);

//            if(now[0]*2 == K) {
//                System.out.println(now[1]);
//                return;
//            };
//            if(now[0]-1 == K) {
//                System.out.println(now[1]+1);
//                return;
//            }
//            if(now[0]+1 == K) {
//                System.out.println(now[1]+1);
//                return;
//            }

            if(now[0]*2 <= 100000 && visited[now[0] * 2] > now[1]) {
                pq.add(new int[] {now[0]*2, now[1]});
                visited[now[0]*2] = now[1];
            }
            if(now[0]-1 >= 0 && now[0]-1 <= 100000 && visited[now[0]-1] > now[1]) {
                pq.add(new int[] {now[0]-1, now[1]+1});
                visited[now[0]-1] = now[1]+1;
            }
            if(now[0]+1 <= 100000 && visited[now[0]+1] > now[1]) {
                pq.add(new int[] {now[0]+1, now[1]+1});
                visited[now[0]+1] = now[1]+1;
            }
        }
        System.out.println(visited[K]);
    }
}
