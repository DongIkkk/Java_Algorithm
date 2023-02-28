package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sol1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[][] sarr = new String[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                sarr[i] = st.nextToken().split("");
            }
            int x=0, y=0;
            outer:
            for(int i=N-1; i>=0; i--){
                for(int j=M-1; j>=0; j--){
                    if( sarr[i][j].equals("1") ){
                        x=i;
                        y=j;
                        break outer;
                    }
                }
            }
            StringBuilder code = new StringBuilder();
            for(int i=y-55; i<=y+2; i++){
                code.append(sarr[x][i]);
            }

            Map<String, Integer> pwpw = new HashMap<>();
            pwpw.put("0001101", 0);
            pwpw.put("0011001", 1);
            pwpw.put("0010011", 2);
            pwpw.put("0111101", 3);
            pwpw.put("0100011", 4);
            pwpw.put("0110001", 5);
            pwpw.put("0101111", 6);
            pwpw.put("0111011", 7);
            pwpw.put("0110111", 8);
            pwpw.put("0001011", 9);

            String pw;
            int num=0;
            int sum = 0;
            int result = 0;
            for(int i=0; i<=7; i++){
                pw = code.substring(7*i, 7*i+7);
                num = pwpw.get(pw);
                sum += num;

                if(i%2 == 0) result += num*3;
                else result += num;
            }

            if(result % 10 == 0) System.out.printf("#%d %d\n",tc,sum);
            else System.out.printf("#%d %d\n",tc,0);
        }
    }
}
