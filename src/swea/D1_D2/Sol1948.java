package D1_D2;

import java.util.Scanner;

public class Sol1948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int tc = 1; tc <= N; tc++) {
            int month1, date1, month2, date2;
            month1 = sc.nextInt();
            date1 = sc.nextInt();
            month2 = sc.nextInt();
            date2 = sc.nextInt();

            int count=1;
            while(true){
                if(month1==month2 && date1==date2) break;
                switch(month1){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (date1<31){
                            date1++;
                            count++;
                        } else if(date1==31){
                            date1=1;
                            month1++;
                            count++;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (date1<30){
                            date1++;
                            count++;
                        } else if(date1==30){
                            date1=1;
                            month1++;
                            count++;
                        }
                        break;
                    case 2:
                        if (date1<28){
                            date1++;
                            count++;
                        } else if(date1==28){
                            date1=1;
                            month1++;
                            count++;
                        }
                        break;


                }
            }
            System.out.printf("#%d %d\n", tc, count);

        }
    }
}
