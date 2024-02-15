package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Sol5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        outer:
        for (int i = 0; i < tc; i++) {
            String command = sc.next();
            int N = sc.nextInt();
            String arr = sc.next();
            arr = arr.substring(1, arr.length()-1);
            String[] numArr = arr.split(",");

            Deque<Integer> dq = new LinkedList<>();

            if(N>=1) {
                for (int j = 0; j < numArr.length; j++) {
                    dq.add(Integer.parseInt(numArr[j]));
                }
            }

            boolean flag = true;

            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);

                if(c == 'R') {
                    flag = !flag;
                } else if(c == 'D') {

                    if(dq.isEmpty()) {
                        System.out.println("error");
                        continue outer;
                    }

                    if(flag) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append("[");

            if(flag) {
                while(!dq.isEmpty()) {
                    sb.append(dq.pollFirst());
                    if(dq.isEmpty()) break;
                    sb.append(",");
                }
            } else {
                while(!dq.isEmpty()) {
                    sb.append(dq.pollLast());
                    if(dq.isEmpty()) break;
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
