package D3;

import java.util.Scanner;

public class Sol3499Queue {
    public static int n = 1000;
    public static String[] arr = new String[n];

    public static int front = -1;
    public static int rear = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            String[] sarr = new String[N];
            for (int i = 0; i < N; i++) {
                sarr[i] = sc.next();
            }
            // 순서대로 큐에 담기
            if(N%2==1){ // 홀수
                for (int i = 0; i <= N/2; i++) {
                    enQueue(sarr[i]);
                    if(i==N/2)break;
                    enQueue(sarr[i+(N/2)+1]);
                }
            } else{
                for (int i = 0; i < N/2; i++) {
                    enQueue(sarr[i]);
                    enQueue(sarr[i+(N/2)]);
                }
            }
            // 출력
            System.out.printf("#%d ",tc);
            print();
            System.out.println();
            clear();
        }

    }
    // 선형 큐 구현
    public static void enQueue(String item){
        if(isFull()){
            System.out.println("큐가 포화상태입니다.");
        } else{
            arr[++rear] = item;
        }
    }


    public static String deQueue() {
        if(isEmpty()){
            System.out.println("큐가 비어있습니다.");
            return null;
        } else{
            return arr[++front];
        }
    }

    public static void print(){
        if(isEmpty()){
            System.out.println("큐가 비어있습니다.");
        } else{
            for(int i=front+1; i<=rear; i++){
                System.out.printf("%s ",arr[i]);
            }
        }
    }

    public static boolean isEmpty(){
        return front==rear;
    }

    public static boolean isFull(){
        return rear == n-1;
    }

    public static int size(){
        return rear-front;
    }

    public static void clear(){
        arr = new String[n];
        front = -1;
        rear = -1;
    }
}
