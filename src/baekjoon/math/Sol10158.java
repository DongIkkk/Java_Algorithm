package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol10158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int w = Integer.parseInt(in.split(" ")[0]);
        int h = Integer.parseInt(in.split(" ")[1]);
        in = br.readLine();
        int p = Integer.parseInt(in.split(" ")[0]);
        int q = Integer.parseInt(in.split(" ")[1]);
        int t = Integer.parseInt(br.readLine());

        if(((int)(p + t) / w) % 2 == 0) {
            p = (p + t) % w;
        }else {
            p = w - (p + t) % w;
        }

        if(((int)(q + t) / h) % 2 == 0) {
            q = (q + t) % h;
        }else {
            q = h - (q + t) % h;
        }
        System.out.println(p + " " + q);
    }
}
