package D1_D2;

import java.util.Scanner;

public class Sol14510 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int[] trees = new int[N];
            int max = -1;
            for(int i=0; i<N; i++){
                trees[i] = sc.nextInt();
                if(max<trees[i]) max=trees[i];
            }

            int count = 0;
            int count1 = 0;
            int count2 = 0;

            int idx = 0;
            int dayday = 1;
            while(idx<=N-1) {
                int tree = max-trees[idx];

                if(tree == 1){
                    count1++;
                    idx++;
                }else if(tree == 2){
                    count2++;
                    idx++;
                }else if(tree >2){
                    while(tree>2){
                        if(count1>=1 && dayday == 1){
                            count++;
                            count1--;
                            dayday=2;
                        } else if(count2>=1 && dayday==2){
                            count++;
                            count2--;
                            dayday=1;
                        } else {
                            tree -= dayday;
                            count++;
                            if (dayday == 1) dayday = 2;
                            else dayday = 1;
                        }
                    }
                    if(tree==1){
                        count1++;
                        idx++;
                    }else if(tree==2){
                        count2++;
                        idx++;
                    }
                }
            }

//            for(int tree:trees){
//                tree = max - tree;
//                if(tree%3 == 0){
//                    count += tree/3 * 2;
//                } else if(tree%3 == 1){
//                    count += tree/3 * 2;
//                    count1++;
//                } else if(tree%3 == 2){
//                    count += tree/3 * 2;
//                    count2++;
//                }
//            }

//            while(count1!=0 && count2!=0){
//                count1--;
//                count2--;
//                count+=2;
//            }

            if(count1>0){
                count += count1 * 2 - 1;
            }
            if(count2>0){
                if(count2%3 == 0) {
                    count2-=3;
                    count+=3;
                }
                count += 1+(count2/3*4)+(count2%3);
            }

            System.out.printf("#%d %d\n",tc,count);
        }
    }
}
