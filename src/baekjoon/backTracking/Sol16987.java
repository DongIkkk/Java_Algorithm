package backTracking;

import java.util.Scanner;

public class Sol16987 {
    static int n, result;
    static int[][] egg;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int hp=0, dmg=0;
        egg = new int[n][2];
        for (int i = 0; i < n; i++) {
            egg[i][0] = sc.nextInt();
            egg[i][1] = sc.nextInt();
        }

        result = 0;
        boolean[] die = new boolean[n];

        eggAttack(0, 0, die);

        System.out.println(result);

    }

    public static void eggAttack(int idx, int count, boolean[] broken){


        // 이미 다깰 수 있다는 걸 안다면 미리 종료
        if(result == n) return;

        // 결과갱신
        if(idx==n) {
            if(result < count) {
                result = count;
            }
            return;
        }

        // 내가이미부서졌다면
        if(broken[idx]){
            eggAttack(idx+1, count, broken);
            return;
        }

        for (int i = 0; i < n ; i++) {
            if(i != idx && !broken[i] ){
                // 내가든계란의 내구도가 내가 칠 계란의 무게보다 크다면 && 내가 든 계란의 무게가 내가 칠 계란의 내구도 보다 크다면 = 칠계란만 부서짐
                if(egg[idx][0] > egg[i][1] && egg[i][0] <= egg[idx][1]){
                    //i 부서짐
                    broken[i] = true;
                    egg[idx][0] -= egg[i][1];
                    eggAttack(idx+1, count+1, broken);
                    broken[i] = false;
                    egg[idx][0] += egg[i][1];
                } else if(egg[idx][0] > egg[i][1] && egg[i][0] > egg[idx][1]){ //둘다 안부서짐
                    egg[idx][0] -= egg[i][1];
                    egg[i][0] -= egg[idx][1];
                    eggAttack(idx+1, count, broken);
                    egg[idx][0] += egg[i][1];
                    egg[i][0] += egg[idx][1];
                } else if(egg[idx][0] <= egg[i][1] && egg[i][0] <= egg[idx][1]){ // 둘다 부서짐
                    broken[i] = true;
                    broken[idx] = true;
                    eggAttack(idx+1, count+2, broken);
                    broken[i] = false;
                    broken[idx] = false;
                } else if(egg[idx][0] <= egg[i][1] && egg[i][0] > egg[idx][1]){
                    broken[idx] = true;
                    egg[i][0] -= egg[idx][1];
                    eggAttack(idx+1, count+1, broken);
                    broken[idx] = false;
                    egg[i][0] += egg[idx][1];
                }
            } else if(count==n-1){
                eggAttack(idx+1, count, broken);
            }
        }

    }
}
