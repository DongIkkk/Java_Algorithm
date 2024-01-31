package implementation;

import java.io.*;
import java.util.*;

public class Sol17143 {
    static public class Shark {
        int r, c, 속력, 방향, 크기;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.속력 = s;
            this.방향 = d;
            this.크기 = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", 속력=" + 속력 +
                    ", 방향=" + 방향 +
                    ", 크기=" + 크기 +
                    '}';
        }
    }

    // 방향 1위 2아래 3우 4좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> sharkList = new ArrayList<>();
        Map<Integer, Shark> sharks = new HashMap<>();

        // 잡을열
        int target = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c == 1) {
                if(target == 0 || sharks.get(target).r > r) {
                    target = i;
                }
            }

            Shark newShark = new Shark(r,c,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            sharks.put(i, newShark);
            sharkList.add(i);
        }

        int[][] map = new int[R+1][C+1];

        for(int sn : sharkList) {
            Shark s = sharks.get(sn);
            map[s.r][s.c] = sn;
        }

        int result = 0;


        for (int i = 1; i <= C; i++) {
//            System.out.println("현재몇초 ? " + i + "    target : " + target);
            // 제거
            if(target > 0) {
                Shark targetShark = sharks.get(target);
                result += targetShark.크기;

                sharks.remove(target);
                sharkList.remove(Integer.valueOf(target));
                map[targetShark.r][targetShark.c] = 0;
                target = 0;
            }

            if(i == C) {
                System.out.println(result);
                return;
            }

            // 새로운맵
            for (int j = 0; j <= R; j++) {
                map[j] = new int[C+1];
            }

            List<Integer> deleteList = new ArrayList<>();
            // 이동시작
//            System.out.println(sharkList.toString());
            for(int sn : sharkList) {
//                System.out.println(sn);
                Shark tempS = sharks.get(sn);
//                System.out.println(tempS.toString());

                int r = tempS.r;
                int c = tempS.c;
                int d = tempS.방향;
                int s = tempS.속력;

                // 상어이동
                for (int j = 0; j < s; j++) {
                    if(d == 1) {
                        if(r == 1) {
                            r++;
                            d = 2;
                        } else {
                            r--;
                        }
                    } else if(d == 2) {
                        if(r == R) {
                            r--;
                            d = 1;
                        } else {
                            r++;
                        }
                    } else if(d == 3) {
                        if(c == C) {
                            c--;
                            d = 4;
                        } else {
                            c++;
                        }
                    } else if(d == 4) {
                        if(c == 1) {
                            c++;
                            d = 3;
                        } else {
                            c--;
                        }
                    }
                }

                // 상어 싸우기 & 잡을 상어 갱신
                if(map[r][c] > 0) {
//                    System.out.printf("r: %d c: %d 누구 %d\n", r,c, map[r][c]);
                    Shark oldShark = sharks.get(map[r][c]);

                    if(oldShark.크기 < tempS.크기) {
                        // oldShark 삭제
                        sharks.remove(map[r][c]);
                        deleteList.add(map[r][c]);
                        if(target == map[r][c]) {
                            target = sn;
                        }
                        map[r][c] = sn;
                        tempS.r = r;
                        tempS.c = c;
                        tempS.방향 = d;
                        sharks.put(sn, tempS);
                    } else {
                        sharks.remove(sn);
                        deleteList.add(sn);
                    }
                } else {
                    if(c == i+1) {
                        if(target == 0 || sharks.get(target).r > r) {
                            target = sn;
                        }
                    }
                    map[r][c] = sn;
                    tempS.r = r;
                    tempS.c = c;
                    tempS.방향 = d;
                    sharks.put(sn, tempS);
                }
            }

            for(int dsn : deleteList) {
                sharkList.remove(Integer.valueOf(dsn));
            }


        }


    }
}
