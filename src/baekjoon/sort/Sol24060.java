package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol24060 {
    static int[] arr;
    static int[] temp;
    static int count = 0;
    static int N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[N];
        count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        mergeSort(0, N-1);
        if(count<k) System.out.println(-1);
    }

    public static void mergeSort(int left, int right){
        if(left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right){
        int L = left;
        int R = mid+1;
        int idx = left;
        while(L <= mid && R <= right){
            if(a[L]<=a[R]){
                temp[idx++] = a[L++];
            }else {
                temp[idx++] = a[R++];
            }
        }

        if(L > mid){
            while(R<=right){
                temp[idx++] = a[R++];
            }
        } else {
            while(L<=mid){
                temp[idx++] = a[L++];
            }
        }

        for(int i = left; i<=right; i++){
            count++;
            if(count == k) {
                System.out.println(temp[i]);
                return;
            }
            arr[i] = temp[i];
        }

    }
}

