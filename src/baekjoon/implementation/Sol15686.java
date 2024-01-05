package implementation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sol15686 {
    public static int M;
    public static ArrayList<Point> house = new ArrayList<>();
    public static ArrayList<Point> chicken = new ArrayList<>();

    public static ArrayList<Point> comb = new ArrayList<>();
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    house.add(new Point(i,j));
                } else if(temp == 2) {
                    chicken.add(new Point(i,j));
                }
            }
        }
        combination(0,0);
        System.out.println(result);
    }

    public static void combination(int start, int count){
        if(count==M) {
            isMin();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            comb.add(chicken.get(i));
            combination(i+1, count+1);
            comb.remove(comb.size()-1);
        }
    }

    public static void isMin(){
        int sum = 0;
        for (Point p: house) {
            int temp = Integer.MAX_VALUE;
            for(Point cp: comb) {
                temp = Math.min(temp, distance(p,cp));
            }
            sum += temp;
            if(sum > result ) return;
        }
        result = Math.min(result, sum);
    }

    public static int distance(Point a, Point b) {
        return (int) (Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()));
    }
}
