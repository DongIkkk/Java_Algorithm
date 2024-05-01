package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol2251 {
    static int[] abc;
    static Set<String> set = new HashSet<>();
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        gogo(new int[] {0,0,abc[2]});

        for(int n: result) System.out.printf("%d ", n);
    }

    public static void gogo(int[] arr) {
        if(set.contains(arr[0] + " " + arr[1] + " " + arr[2])) return;
        set.add(arr[0] + " " + arr[1] + " " + arr[2]);
        if(arr[0] == 0) result.add(arr[2]);

        // c -> a
        gogo(new int[] {abc[0] - arr[0] < arr[2] ? abc[0] : arr[0] + arr[2], arr[1], abc[0] - arr[0] < arr[2] ? arr[2] - abc[0] + arr[0] : 0});
        // c -> b
        gogo(new int[] {arr[0], abc[1] - arr[1] < arr[2] ? abc[1] : arr[1] + arr[2], abc[1] - arr[1] < arr[2] ? arr[2] - abc[1] + arr[1] : 0});
        // a -> b
        gogo(new int[] {abc[1] - arr[1] < arr[0] ? arr[0] - abc[1] + arr[1] : 0, abc[1] - arr[1] < arr[0] ? abc[1] : arr[1] + arr[0], arr[2]});
        // a -> c
        gogo(new int[] {abc[2] - arr[2] < arr[0] ? arr[0] - abc[2] + arr[2] : 0, arr[1], abc[2] - arr[2] < arr[0] ? abc[2] : arr[2] + arr[0]});
        // b -> a
        gogo(new int[] {abc[0] - arr[0] < arr[1] ? abc[0] : arr[0] + arr[1], abc[0] - arr[0] < arr[1] ? arr[1] - abc[0] + arr[0] : 0, arr[2]});
        // b -> c
        gogo(new int[] {arr[0], abc[2] - arr[2] < arr[1] ? arr[1] - abc[2] + arr[2] : 0, abc[2] - arr[2] < arr[1] ? abc[2] : arr[2] + arr[1]});
    }
}
