package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int goal = sc.nextInt();

        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visited[n] = true;
        while(q.size()!=0){
            int now = q.poll();

            if(now == goal){
                System.out.println(dist[now]);
                break;
            }

            if(now-1>=0 && !visited[now-1]){
                q.add(now-1);
                visited[now-1] = true;
                dist[now-1] = dist[now] + 1;
            }
            if(now+1<100001 && !visited[now+1]){
                q.add(now+1);
                visited[now+1] = true;
                dist[now+1] = dist[now] + 1;
            }
            if(now*2<100001 && !visited[now*2]){
                q.add(now*2);
                visited[now*2] = true;
                dist[now*2] = dist[now] + 1;
            }
        }
    }
}
