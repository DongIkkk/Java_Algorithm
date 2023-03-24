package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2112 {
    static int d,w,k;
    static int[][] film;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()); // x
            w = Integer.parseInt(st.nextToken()); // y
            k = Integer.parseInt(st.nextToken()); //합격기준
            film = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = d+1;
            find(0,0);
            System.out.printf("#%d %d\n", tc, result);


        }
    }

    public static void find(int count, int idx){
        if(isPass()) {
            if(result>count){
                result = count;
            }
            return;
        }

        if(count == d ) return;
        if(idx == d) return;



        int[] temp;
        find(count, idx+1);

        temp = yak0(idx);
        find(count+1, idx+1);
        cancel(idx, temp);

        temp = yak1(idx);
        find(count+1, idx+1);
        cancel(idx, temp);


    }

    public static void cancel(int h, int[] temp){
        for (int i = 0; i < w; i++) {
            film[h][i] = temp[i];
        }
    }
    public static int[] yak0(int h){
        int[] temp = new int[w];
        for (int i = 0; i < w; i++) {
            temp[i] = film[h][i];
            film[h][i] = 0;
        }
        return temp;
    }
    public static int[] yak1(int h){
        int[] temp = new int[w];
        for (int i = 0; i < w; i++) {
            temp[i] = film[h][i];
            film[h][i] = 1;
        }
        return temp;
    }

    public static boolean isPass(){
        for (int i = 0; i < w; i++) {
            int k0=0, k1=0;
            for (int j = 0; j < d; j++) {
                if(film[j][i]==0){
                    k0++;
                    k1=0;
                }else{
                    k0=0;
                    k1++;
                }
                if(k0 == k || k1 == k) break;
                if(j==d-1){
                    if(k0<k && k1<k) return false;
                }
            }
        }
        return true;
    }
}
