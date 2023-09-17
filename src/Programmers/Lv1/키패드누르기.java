package Lv1;

class 키패드누르기 {
    public String solution(int[] numbers, String hand) {

        // 2580 을 누를 때
        int[] left = new int[] {4,3,2,1};
        int[] right = new int[] {4,3,2,1};
        StringBuilder sb = new StringBuilder();
        for(int n: numbers){
            switch (n){
                case 1:
                    sb.append("L");
                    left = new int[] {1,2,3,4};
                    break;
                case 4:
                    sb.append("L");
                    left = new int[] {2,1,2,3};
                    break;
                case 7:
                    sb.append("L");
                    left = new int[] {3,2,1,2};
                    break;
                case 3:
                    sb.append("R");
                    right = new int[] {1,2,3,4};
                    break;
                case 6:
                    sb.append("R");
                    right = new int[] {2,1,2,3};
                    break;
                case 9:
                    sb.append("R");
                    right = new int[] {3,2,1,2};
                    break;
                case 2:
                    if(left[0]<right[0]){
                        sb.append("L");
                        left = new int[] {0, 1, 2, 3};
                    } else if(left[0]>right[0]){
                        sb.append("R");
                        right = new int[] {0,1,2,3};
                    } else {
                        if(hand.equals("right")){
                            sb.append("R");
                            right = new int[] {0,1,2,3};
                        } else{
                            sb.append("L");
                            left = new int[] {0, 1, 2, 3};
                        }
                    }
                    break;
                case 5:
                    if(left[1]<right[1] ){
                        sb.append("L");
                        left = new int[] {1,0,1,2};
                    } else if(left[1]>right[1]){
                        sb.append("R");
                        right = new int[] {1,0,1,2};
                    } else {
                        if(hand.equals("right")){
                            sb.append("R");
                            right = new int[] {1,0,1,2};
                        } else{
                            sb.append("L");
                            left = new int[] {1,0,1,2};
                        }
                    }
                    break;
                case 8:
                    if(left[2]<right[2]){
                        sb.append("L");
                        left = new int[] {2,1,0,1};
                    } else if(left[2]>right[2]){
                        sb.append("R");
                        right = new int[] {2,1,0,1};
                    } else {
                        if(hand.equals("right")){
                            sb.append("R");
                            right = new int[] {2,1,0,1};
                        } else{
                            sb.append("L");
                            left = new int[] {2,1,0,1};
                        }
                    }
                    break;
                case 0:
                    if(left[3]<right[3]){
                        sb.append("L");
                        left = new int[] {3,2,1,0};
                    } else if(left[3]>right[3]){
                        sb.append("R");
                        right = new int[] {3,2,1,0};
                    } else {
                        if(hand.equals("right")){
                            sb.append("R");
                            right = new int[] {3,2,1,0};
                        } else{
                            sb.append("L");
                            left = new int[] {3,2,1,0};
                        }
                    }
                    break;
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
