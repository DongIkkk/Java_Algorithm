package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        int num = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            stack.push(num); // 입력 스택
        }

        int[] result = new int[N+1]; // 결과를 저장할 배열

        Stack<Integer> tempSt = new Stack<>(); // 임시 배열
        Stack<Integer> idxSt = new Stack<>();

        // 최솟값을 가지고 다님..
        // 근데 한번 갱신되면 다음친구도 갱신가능하면 다음친구도 갱신가능하면
        // 아니면 계속가

        int meetidx = N; // 갱신될때 만난애
        tempSt.push(stack.pop());
        idxSt.push(N);
        while(stack.size()!=0){
            int temp = stack.pop();
            meetidx -= 1;

            if(tempSt.size()>0 && tempSt.peek() <= temp){
                tempSt.pop();
                result[idxSt.pop()] = meetidx;
                while(tempSt.size()!=0){
                    if(tempSt.peek() <= temp){
                        tempSt.pop();
                        result[idxSt.pop()] = meetidx;
                    } else{
                        break;
                    }
                }
                tempSt.push(temp);
                idxSt.push(meetidx);
            } else{
                tempSt.push(temp);
                idxSt.push(meetidx);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
