package math;

import java.util.Scanner;

public class Sol11664 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int az = sc.nextInt();

        int bx = sc.nextInt();
        int by = sc.nextInt();
        int bz = sc.nextInt();

        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int cz = sc.nextInt();

        double sx = ax;
        double sy = ay;
        double sz = az;

        double ex = bx;
        double ey = by;
        double ez = bz;

        int count = 0;

        while (true) {
            if (count == 10000) break;

            double mx = (sx + ex) / 2;
            double my = (sy + ey) / 2;
            double mz = (sz + ez) / 2;

            if (dis(sx, sy, sz, cx, cy, cz) < dis(ex, ey, ez, cx, cy, cz)) {
                ex = mx;
                ey = my;
                ez = mz;
            } else {
                sx = mx;
                sy = my;
                sz = mz;
            }
            count++;
        }

        System.out.printf("%.10f", dis(sx, sy, sz, cx, cy, cz));

    }

    public static double dis(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }

}


//        // 벡터 ab -> A
//        int abx = bx - ax;
//        int aby = by - ay;
//        int abz = bz - az;
//
//        // 벡터 bc -> B
//        int bcx = cx - bx;
//        int bcy = cy - by;
//        int bcz = cz - bz;
//
//        // 내적
//        double dp = abx*bcx + aby*bcy + abz*bcz;
//
//        // 벡터의크기
//        double A = Math.sqrt(abx*abx + aby*aby + abz*abz);
//        double B = Math.sqrt(bcx*bcx + bcy*bcy + bcz*bcz);
//
//        double cos = dp / (A*B);
//
//        // 수선의발 H 길이 BH
//        double bcdistance = Math.sqrt((cx-bx)*(cx-bx) + (cy-by)*(cy-by) + (cz-bz)*(cz-bz));
//        double bh = bcdistance * cos;
//
//        // 단위벡터
//        double unitBCx = bcx / B;
//        double unitBCy = bcy / B;
//        double unitBCz = bcz / B;
//
//        // BH 벡터
//        double bhx = unitBCx * bh;
//        double bhy = unitBCy * bh;
//        double bhz = unitBCz * bh;
//
//        // 점 H의 좌표
//        double hx = bx + bhx;
//        double hy = by + bhy;
//        double hz = bz + bhz;
//
//        double result = Math.sqrt((cx-hx)*(cx-hx) + (cy-hy)*(cy-hy) + (cz-hz)*(cz-hz));
//        System.out.println(result);
