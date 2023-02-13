package basic;

import java.util.Scanner;

public class Sol1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count = 0;
        int month = 1;
        int date = 1;
        while(true){
            if(month == x && date == y) break;
            count++;
            switch(month){
                case 1: case 3: case 5:
                case 7: case 8: case 10: case 12:
                    if(date==31){
                        month += 1;
                        date = 1;
                    } else{
                        date += 1;
                    }
                    break;
                case 4: case 6: case 9: case 11:
                    if(date==30){
                        month += 1;
                        date = 1;
                    } else{
                        date += 1;
                    }
                    break;
                case 2:
                    if(date==28){
                        month += 1;
                        date = 1;
                    } else{
                        date += 1;
                    }
                    break;

            }
        }
        count = count % 7;
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        System.out.println(week[count]);
    }
}
