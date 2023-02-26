package implementation;

import java.util.Scanner;

public class Sol2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] type = new int[8];
        int[] dis = new int[8];


        for (int i=0; i<6; i++){
            type[i] = sc.nextInt();
            dis[i] = sc.nextInt();
        }

        type[6] = type[0];
        dis[6] = dis[0];
        type[7] = type[1];
        dis[7] = dis[1];
        int total = 0;

        for(int i=0; i<6; i++){
            if(isisis(type[i], type[i+1])) {
                if(i==0){
                    total = (dis[i]+dis[i+2]) * (dis[5]+dis[i+1]) - (dis[i] * dis[i+1]);
                } else{
                    total = (dis[i]+dis[i+2]) * (dis[i-1]+dis[i+1]) - (dis[i] * dis[i+1]);
                }
                break;
            }
        }

        System.out.println(total*T);

    }

    static public boolean isisis(int x, int y){
        if(x==2 && y==4) return true;
        if(x==3 && y==2) return true;
        if(x==1 && y==3) return true;
        if(x==4 && y==1) return true;
        return false;
    }
}
