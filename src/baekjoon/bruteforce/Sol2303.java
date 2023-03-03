package bruteforce;

import java.util.Scanner;

public class Sol2303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //각사람점수
        int[] score = new int[N];
        // 각사람점수만들기
        for (int i = 0; i < N; i++) {
            int[] cards = new int[5];
            for(int j=0; j<5;j++){
                cards[j] = sc.nextInt();
            }
            int max=-1;
            for(int k=0; k<5; k++){
                for(int l=0; l<5; l++){
                    for(int m=0; m<5; m++){
                        if(k!=l && l!=m && k!=m){
                            int nnn = (cards[k] + cards[l]+ cards[m]) % 10;
                            if(nnn>max) max=nnn;
                        }
                    }
                }
            }
            score[i] = max;
        }

        int maxperson=-1;
        int maxpersonscore = -1;
        for(int i=0; i<N; i++){
            if(score[i]>=maxpersonscore) {
                maxpersonscore = score[i];
                maxperson = i;
            }
        }
        System.out.println(maxperson+1);
    }
}
