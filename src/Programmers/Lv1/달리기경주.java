package Lv1;

import java.util.*;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        Map<Integer, String> who = new HashMap<>();

        for(int i=0; i<players.length; i++){
            rank.put(players[i], i+1);
            who.put(i+1, players[i]);
        }

        for(int i=0; i<callings.length; i++){
            int temp = rank.get(callings[i]);
            String tempWho = who.get(temp-1);

            rank.put(callings[i], temp-1);
            rank.put(tempWho, temp);
            who.put(temp-1, callings[i]);
            who.put(temp, tempWho);
        }

        String[] answer = new String[players.length];
        for(int i=0; i<players.length; i++){
            answer[i] = who.get(i+1);
        }

        return answer;
    }
}
