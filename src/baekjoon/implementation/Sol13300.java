package implementation;

import java.util.Scanner;

public class Sol13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] stu = new int[13];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int sex = sc.nextInt();
            int grade = sc.nextInt();

            stu[sex*6 + grade]++;
            if(stu[sex*6 + grade] == k){
                stu[sex*6 + grade] = 0;
                count++;
            }
        }
        for (int n:stu){
            if(n>0) count++;
        }
        System.out.println(count);
    }
}
