package DFSBFS;
import java.util.*;

public class treeBFSstudy {
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer>[] treeBFS;
    static List<Integer> visited;

    public static void main(String[] args) {
        // 리스트라는 객체를 담는 배열
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        treeBFS = new ArrayList[N+1];
        visited = new ArrayList<>();

        int T = sc.nextInt();

        for(int i=1; i<=N; i++){
            treeBFS[i] = new ArrayList<>();
        }
        for(int i=0; i<T; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
//        if(parent == -1 && child == -1){
//            break;
//        }
            treeBFS[parent].add(child);
        }
        BFS(1);

        System.out.println(Arrays.toString(treeBFS));
        System.out.println(visited);
    }
    public static void BFS(int x){
        q.add(x);
        visited.add(x);

        while(q.size()>0){
            for(int n:treeBFS[q.poll()]){
                visited.add(n);
                q.add(n);
            }
        }
    }
}
