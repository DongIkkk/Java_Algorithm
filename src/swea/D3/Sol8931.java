package D3;

import java.util.Scanner;

public class Sol8931 {

    static int[] arr = new int[10];
    static int top = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            for(int i=0; i<N; i++) {
                int in = sc.nextInt();
                if(in == 0) {
                    pop();
                }else {
                    push(in);
                }
            }

            int sum=0;
            while(!isEmpty()) {
                sum +=  pop();
            }

            System.out.printf("#%d %d\n", tc, sum);
        }
    }


    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isFull() {
        return top==arr.length -1;
    }


    static void push(int x) {
        if(top == arr.length-1) {
            int[] arr2 = new int[arr.length * 2];
            for(int i=0; i<arr.length; i++) {
                arr2[i] = arr[i];
            }
            arr2[++top] = x;
            arr = arr2;
        } else {
            arr[++top] = x;
        }
    }


    static int pop() {
        if(top == -1) {
            return -1;
        } else {
            return arr[top--];
        }
    }

    static void print() {
        for(int i = top; i>=0; i--) {
            System.out.println(arr[i]+" ");
        }
    }
}
