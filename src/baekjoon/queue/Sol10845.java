package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                int n = Integer.parseInt(st.nextToken());
                last =n;
                q.add(n);
            } else if(s.equals("front")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            } else if(s.equals("back")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(last);
            } else if(s.equals("size")){
                System.out.println(q.size());
            } else if( s.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else{
                    System.out.println(q.poll());
                }
            }else if(s.equals("empty")){
                if(q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
}

