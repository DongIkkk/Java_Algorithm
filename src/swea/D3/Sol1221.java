package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol1221 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int T = Integer.parseInt(s);
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] count = new int[10];
            for(int i=0; i<N; i++){
                if(st.nextToken().equals("ZRO")) count[0]++;
                if(st.nextToken().equals("ONE")) count[1]++;
                if(st.nextToken().equals("TWO")) count[2]++;
                if(st.nextToken().equals("THR")) count[3]++;
                if(st.nextToken().equals("FOR")) count[4]++;
                if(st.nextToken().equals("FIV")) count[5]++;
                if(st.nextToken().equals("SIX")) count[6]++;
                if(st.nextToken().equals("SVN")) count[7]++;
                if(st.nextToken().equals("EGT")) count[8]++;
                if(st.nextToken().equals("NIN")) count[9]++;
            }

            for(int i=0; i<=9; i++){
                for(int j=0; j<count[i]; j++){
                    if(i==0) System.out.printf("#%s ","ZRO");
                    if(i==1) System.out.printf("#%s ","ONE");
                    if(i==2) System.out.printf("#%s ","TWO");
                    if(i==3) System.out.printf("#%s ","THR");
                    if(i==4) System.out.printf("#%s ","FOR");
                    if(i==5) System.out.printf("#%s ","FIV");
                    if(i==6) System.out.printf("#%s ","SIX");
                    if(i==7) System.out.printf("#%s ","SVN");
                    if(i==8) System.out.printf("#%s ","EGT");
                    if(i==9) System.out.printf("#%s ","NIN");
                }
            }
            System.out.println();
        }
    }
}
