package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());


        int[] temp1 = new int[n+1];
        int[] temp2 = new int[n+1];
        int num;

        st = new StringTokenizer(br.readLine());
        temp1[0] = Integer.parseInt(st.nextToken());

        int result = temp1[0];

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            if(i%2 == 0){
                for (int j = 0; j < i; j++) {
                    num = Integer.parseInt(st.nextToken());

                    if(j == 0) {
                        temp2[j] = temp1[0] + num;
                        result = Math.max(result, temp2[j]);
                    } else if(j == i-1) {
                        temp2[j] = temp1[j-1] + num;
                        result = Math.max(result, temp2[j]);
                    } else {
                        temp2[j] = num + Math.max(temp1[j], temp1[j-1]);
                        result = Math.max(result, temp2[j]);
                    }
                }
            } else {
                for (int j = 0; j < i; j++) {
                    num = Integer.parseInt(st.nextToken());

                    if(j == 0) {
                        temp1[j] = temp2[0] + num;
                        result = Math.max(result, temp1[j]);
                    } else if(j == i-1) {
                        temp1[j] = temp2[j-1] + num;
                        result = Math.max(result, temp1[j]);
                    } else {
                        temp1[j] = num + Math.max(temp2[j], temp2[j-1]);
                        result = Math.max(result, temp1[j]);
                    }
                }
            }
        }

        System.out.println(result);
    }
}
