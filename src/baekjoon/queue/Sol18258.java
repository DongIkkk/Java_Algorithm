package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        String command = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if(command.equals("push")){
                int pushNum = Integer.parseInt(st.nextToken());
                q.add(pushNum);
            } else if(command.equals("pop")){
                if(q.size()==0){
                    sb.append(-1);
                    sb.append("\n");
                } else{
                    sb.append(q.poll());
                    sb.append("\n");
                }
            } else if(command.equals("size")){
                sb.append(q.size());
                sb.append("\n");
            } else if(command.equals("empty")){
                if(q.size() == 0){
                    sb.append(1);
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            } else if(command.equals("front")){
                if(q.size()==0){
                    sb.append(-1);
                    sb.append("\n");
                } else{
                    sb.append(q.getFirst());
                    sb.append("\n");
                }
            } else if(command.equals("back")){
                if(q.size()==0){
                    sb.append(-1);
                    sb.append("\n");
                } else{
                    sb.append(q.getLast());
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
