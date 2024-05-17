package greedy;

import java.io.*;
import java.util.*;

public class Sol19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = new char[N];

        String in = br.readLine();
        for (int i = 0; i < in.length(); i++) {
            arr[i] = in.charAt(i);
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P') {
                for (int j = -K; j <= K; j++) {
                    if(i+j >= 0 && i+j < N && arr[i+j] == 'H') {
                        arr[i+j] = '.';
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.print(result);
    }
}
