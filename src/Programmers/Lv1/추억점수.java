
package Lv1;
import java.util.*;
class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i=0; i< photo.length; i++){
            String[] temp = photo[i];
            int score = 0;

            for(int j=0; j<temp.length; j++){
                String s = temp[j];
                if(map.containsKey(s)){
                    score += map.get(s);
                }
            }
            answer[i]=score;
        }
        return answer;
    }
}
