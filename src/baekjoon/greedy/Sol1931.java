package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numList = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            numList[i] = b;
            if(!map.containsKey(b)){
                map.put(b,a);
            }else{
                if(a > map.get(b)){
                    map.replace(b,a);
                }
            }
        }

//        System.out.println(map);

        Arrays.sort(numList);

//        System.out.println(Arrays.toString(numList));

//        Set<Integer> set = new HashSet<>();

//        for(int num:numList){
//            set.add(num);
//        }

//        System.out.println(set);
        int now = 0;
        int count = 0;

        for(int num : numList){
            if(now <= map.get(num)){
//                System.out.println(now);
                now = num;
                count++;
            }
        }

        System.out.println(count);

    }
}
