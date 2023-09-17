package Lv1;

public class 로또최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int nice = 0;
        int bad = 0;
        int mollu = 0;
        boolean isNice = false;
        for(int i=0; i<lottos.length; i++){
            int temp = lottos[i];
            if(temp == 0){
                mollu++;
                continue;
            }

            for(int j=0; j<win_nums.length; j++){

                if(temp == win_nums[j]){
                    isNice = true;
                }

            }

            if(isNice){
                nice++;
                isNice = false;
            } else {
                bad++;
            }
        }

        int best = 0;
        int worst = 0;

        int forBest = nice+mollu;

        if(nice == 6){
            answer[1] = 1;
        } else if(nice == 5){
            answer[1] = 2;
        } else if(nice == 4){
            answer[1] = 3;
        } else if(nice == 3){
            answer[1] = 4;
        } else if(nice == 2){
            answer[1] = 5;
        } else {
            answer[1] = 6;
        }

        if(forBest == 6){
            answer[0] = 1;
        } else if(forBest == 5){
            answer[0] = 2;
        } else if(forBest == 4){
            answer[0] = 3;
        } else if(forBest == 3){
            answer[0] = 4;
        } else if(forBest == 2){
            answer[0] = 5;
        } else {
            answer[0] = 6;
        }

        return answer;
    }
}
