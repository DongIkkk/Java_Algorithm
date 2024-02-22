package implementation;

import java.awt.*;
import java.util.*;
import java.io.*;

public class Sol3190 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N+1][N+1];

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }

        int L = sc.nextInt();

        Map<Integer, Character> moving = new HashMap<>();

        for (int i = 0; i < L; i++) {
            int sec = sc.nextInt();
            char c = sc.next().charAt(0);

            moving.put(sec, c);
        }

        int time = 0;
        Deque<Point> dq = new LinkedList<>();
        dq.add(new Point(1,1));

        int direction = 0;  // 0우 1하 2좌 3상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int nextx, nexty;
        while(true) {
            time++;
            Point head = dq.getFirst(); // 대가리꺼내서 다음방향
            nextx = head.x + dx[direction];
            nexty = head.y + dy[direction];

            if(nextx < 1 || nexty < 1 || nextx > N || nexty > N) break; // 맵밖이면 스탑

            Point next = new Point(nextx, nexty); // 나한테박으면 스탑

            if(dq.contains(next)) break;

            if(map[nextx][nexty] == 1) {    // 사과라면
                dq.addFirst(next);
                map[nextx][nexty] = 0;
            } else { // 노사과면 꼬리 없어짐
                dq.addFirst(next);
                dq.pollLast();
            }

            // 방향전환
            if(moving.containsKey(time)){
                if(moving.get(time) == 'L') {
                    direction = (direction+3) % 4;
                } else if(moving.get(time) == 'D') {
                    direction = (direction+1) % 4;
                }
            }
        }

        System.out.println(time);
    }
}
