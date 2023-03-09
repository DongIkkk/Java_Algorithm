package DFSBFS;
import java.util.*;

public class treeDFSstudy {
    static Stack<Integer> stack = new Stack<>();
    static List<Integer>[] treeDFS;
    static List<Integer> visited;

    public static void main(String[] args) {
        // 리스트라는 객체를 담는 배열
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        treeDFS = new ArrayList[N+1];
        visited = new ArrayList<>();

        int T = sc.nextInt();

        for(int i=1; i<=N; i++){
            treeDFS[i] = new ArrayList<>();
        }
        for(int i=0; i<T; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            //        if(parent == -1 && child == -1){
            //            break;
            //        }
            treeDFS[parent].add(child);
        }
        DFS(1);

        System.out.println(Arrays.toString(treeDFS));
        System.out.println(visited);
    }
    public static void DFS(int x){
        if(stack.empty()) {
            stack.add(x);
            visited.add(x);
        }
        while(stack.size()!=0) {
            for(int num : treeDFS[stack.pop()]){
                stack.add(num);
                visited.add(num);
                if(treeDFS[num].size()>0) {
                    DFS(num);
                }
            }
        }
    }
}
