package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1063 {
    static String king, stone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken();
        stone = st.nextToken();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            String temp = move(king, S);
            String tempStone = move(stone, S);
            if(temp.equals("ER")) continue;
            if(temp.equals(stone)) {
                if(tempStone.equals("ER")) continue;
                stone = tempStone;
            }
            king = temp;
        }
        System.out.println(king);
        System.out.println(stone);
    }

    public static String move(String now, String command) {
        String result = "";
        if(command.equals("R")) {
            if(now.charAt(0) >= 'H') return "ER";
            result += (char)(now.charAt(0) + 1);
            result += now.charAt(1);
        } else if(command.equals("L")) {
            if(now.charAt(0) <= 'A') return "ER";
            result += (char)(now.charAt(0) - 1);
            result += now.charAt(1);
        } else if(command.equals("B")) {
            if(now.charAt(1) <= '1') return "ER";
            result += now.charAt(0);
            result += now.charAt(1) - '0' - 1;
        } else if(command.equals("T")) {
            if(now.charAt(1) >= '8') return "ER";
            result += now.charAt(0);
            result += now.charAt(1) - '0' + 1;
        } else if(command.equals("RT")) {
            if(now.charAt(0) >= 'H') return "ER";
            if(now.charAt(1) >= '8') return "ER";
            result += (char)(now.charAt(0) + 1);
            result += now.charAt(1) - '0' + 1;
        } else if(command.equals("LT")) {
            if(now.charAt(0) <= 'A') return "ER";
            if(now.charAt(1) >= '8') return "ER";
            result += (char)(now.charAt(0) - 1);
            result += now.charAt(1) - '0' + 1 ;
        } else if(command.equals("RB")) {
            if(now.charAt(0) >= 'H') return "ER";
            if(now.charAt(1) <= '1') return "ER";
            result += (char)(now.charAt(0) + 1);
            result += now.charAt(1) - '0' - 1;
        } else if(command.equals("LB")) {
            if(now.charAt(0) <= 'A') return "ER";
            if(now.charAt(1) <= '1') return "ER";
            result += (char)(now.charAt(0) - 1);
            result += now.charAt(1) - '0' - 1;
        }
        return result;
    }
}
