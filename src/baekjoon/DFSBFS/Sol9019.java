package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol9019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Queue<Object[]> q = new LinkedList<>();
        int nowx=0;
        String nows="";
        for (int tc = 1; tc <= T ; tc++) {
            int[] visited = new int[10000];
            q.clear();
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = "";
            q.add(new Object[]{a, s});
            while(q.size()!=0){
                Object[] o =q.poll();

                nowx = (int)o[0];
                nows = (String)o[1];

                int temp = (2 * nowx) % 10000;
                if(visited[temp]==0){
                    visited[temp]++;
                    if(temp==b){
                        System.out.println(nows+"D");
                        break;
                    } else{
                        q.add(new Object[]{temp, nows+"D"});
                    }
                }


                if(nowx==0) temp = 9999;
                else temp = nowx-1;

                if(visited[temp]==0) {
                    visited[temp]++;
                    if (temp == b) {
                        System.out.println(nows + "S");
                        break;
                    } else {
                        q.add(new Object[]{temp, nows + "S"});
                    }
                }


                if(nows.length()==0 || nows.charAt(nows.length()-1) != 'R'){
                    int t1000 = nowx%1000;
                    int temp4 = (int)nowx/1000;
                    temp = t1000*10 + temp4;

                    if(visited[temp]==0) {
                        visited[temp]++;
                        if (temp == b) {
                            System.out.println(nows + "L");
                            break;
                        } else {
                            q.add(new Object[]{temp, nows + "L"});
                        }
                    }
                }

                if(nows.length()==0 || nows.charAt(nows.length()-1) != 'L') {
                    int temp1 = (int)nowx%10;
                    int t10 = (int)nowx/10;
                    temp = temp1*1000 + t10;

                    if(visited[temp]==0) {
                        visited[temp]++;
                        if (temp == b) {
                            System.out.println(nows + "R");
                            break;
                        } else {
                            q.add(new Object[]{temp, nows + "R"});
                        }
                    }
                }
            }
        }
    }
}
