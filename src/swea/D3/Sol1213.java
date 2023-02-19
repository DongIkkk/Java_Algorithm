package D3;

import java.io.*;
import java.util.*;

public class Sol1213 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10 ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            char[] search = st.nextToken().toCharArray();
            st = new StringTokenizer(br.readLine());
            char[] in = st.nextToken().toCharArray();

            int i=0;
            int j=0;
            int result = 0;
            while(i<in.length && j<search.length) {
                if(in[i] != search[j]) {
                    i=i-j;
                    j=0;
                }else j++;

                i++;

                if(j == search.length) {
                    result++;
                    j=0;
                }
            }

            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
