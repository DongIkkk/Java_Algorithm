package MapSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sol1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);
        int idx=1;
        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N+1];
        for(int i=0; i<N; i++) {
            String in = br.readLine();
            arr[idx]= in;
            map.put(in, idx++);

        }

        for(int i=0; i<M; i++) {
            String ss = br.readLine();
            if(isNum(ss)) {
                System.out.println(arr[Integer.parseInt(ss)]);
            }else {
                System.out.println(map.get(ss));
            }
        }

    }

    public static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
