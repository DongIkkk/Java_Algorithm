package D3;

public class Countingsort {
    public static void main(String[] args) {

        int[] arr = {6, 4, 1, 3, 2, 5, 4, 1, 2, 4, 3, 5, 4, 3, 6, 1, 5, 2, 1, 4, 3, 2, 4, 6, 2, 1, 5, 3, 1, 4, 5, 3, 1, 5, 6, 1, 4, 2, 3, 6, 1, 5, 4};
        int n = arr.length;
        int 최대값 = 6;

        int[] 카운팅 = new int[최대값+1];
        int[] 누적합 = new int[최대값+1];

        for(int num: arr) {
            카운팅[num]++;
        }

        누적합[0] = 카운팅[0];
        for(int i=1; i<7; i++) {
            누적합[i] = 누적합[i-1]+카운팅[i];
        }

        int[] arr2 = new int[n];
        for(int i=n-1; i>=0; i-- ) {
            누적합[arr[i]]--;
            arr2[누적합[arr[i]]] = arr[i];
        }

        for(int i=0; i<arr2.length; i++) {
            System.out.printf("%d ",arr2[i]);
        }


    }
}
