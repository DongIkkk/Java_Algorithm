package D4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol2105 {
    static int n, result, startx, starty;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = -1;
            for (int i = 0; i < n-1; i++) {
                for (int j = 1; j < n-1; j++) {

                    List<Integer> visited = new ArrayList<>();
                    startx = i;
                    starty = j;
                    go(i, j, visited, 1);
                }
            }

            System.out.printf("#%d %d\n", tc, result);
        }

    }

    public static void go(int x, int y, List<Integer> visited, int status){

        if(status>= 3 && (visited.size() < (result/2)+1)) return;
        if(visited.size()>0 && x == startx && y == starty){
            if(result<visited.size()) result = visited.size();
            return;
        }
        if(x<0 || y<0 || x==n || y==n) return;

        if (visited.contains(map[x][y])){
            return;
        } else{
            visited.add(map[x][y]);
        }
        List<Integer> visited2 = new ArrayList<>(visited);
        switch(status){
            // 왼쪽아래로 가던중 1
            case 1:
                go(x+1, y-1, visited2, 1);
                List<Integer> visited3 = new ArrayList<>(visited);
                go(x+1, y+1, visited3, 2);
                break;
            // 오른쪽아래로가던중 2
            case 2:
                List<Integer> visited4 = new ArrayList<>(visited);
                go(x+1, y+1, visited4, 2);
                List<Integer> visited5 = new ArrayList<>(visited);
                go(x-1, y+1, visited5, 3);
                break;
            // 오른쪽 위로가던중 3
            case 3:
                List<Integer> visited6 = new ArrayList<>(visited);
                go(x-1, y+1, visited6, 3);
                List<Integer> visited7 = new ArrayList<>(visited);
                go(x-1, y-1, visited7, 4);
                break;
            // 왼쪽위로가던중 4
            case 4:
                List<Integer> visited8 = new ArrayList<>(visited);
                go(x-1, y-1, visited8, 4);
                List<Integer> visited9 = new ArrayList<>(visited);
                go(x+1, y-1, visited9, 1);
                break;
        }
    }

}
