package Lv2;

import java.util.*;

public class 광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o2[0] - o1[0];
                }
        );

        int total = 0;
        for(int i=0; i<3; i++){
            total += picks[i];
        }

        int sum = 0;
        int count = 0;
        for(int i=0; i<minerals.length; i++){
            char c = minerals[i].charAt(0);
            switch(c){
                case 'd':
                    sum += 25;
                    break;
                case 'i':
                    sum += 5;
                    break;
                case 's':
                    sum += 1;
                    break;
            }
            if(++count % 5 == 0 || i==minerals.length-1) {
                pq.add(new int[] {sum, i-count+1});
                count = 0;
                sum = 0;
                if(pq.size() == total) break;
            }
        }

        int pick = 0;
        while(true) {
            if(picks[0] != 0){
                pick=0;
            } else if(picks[1] != 0){
                pick = 1;
            } else if(picks[2] != 0) {
                pick = 2;
            } else {
                break;
            }

            if(pq.size() == 0) break;

            int temp = pq.poll()[1];
            for(int i = temp; i<temp+5; i++){
                if(pick == 1){
                    if(minerals[i].equals("diamond")){
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                } else if(pick == 2){
                    if(minerals[i].equals("diamond")){
                        answer += 25;
                    } else if(minerals[i].equals("iron")){
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                } else {
                    answer += 1;
                }

                if(i==minerals.length-1) break;
            }
            picks[pick]--;
        }

        return answer;
    }
}
