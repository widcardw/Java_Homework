package src.T02;

import java.util.Scanner;

// n只蚂蚁以每秒1cm的速度在长度为Lcm的竿子上爬行。
// 当蚂蚁爬行到竿子的端点时就会掉落。由于竿子太细，
// 两只蚂蚁相遇时，它们不能交错通过，只能各自反向爬
// 回去。对于每只蚂蚁，我们知道它距离竿子左端的距离xi，
// 但不知道它的朝向。请计算所有的蚂蚁落下竿子的最短时间和最长时间
public class Test38 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入杆子的长度L：");
        int L = input.nextInt();
        System.out.print("请输入蚂蚁的数量n：");
        int n = input.nextInt();
        System.out.print("请输入每只蚂蚁的距离：");
        int[] xi = new int[n];
        for (int i = 0; i < n; i++) {
            xi[i] = input.nextInt();
        }
        input.close();
        boolean[] dir1 = new boolean[n];
        boolean[] dir2 = new boolean[n];
        int time[] = { 0, 0 };
        getSolution(L, n, xi, dir1, dir2, time);

        System.out.print("最短时间：" + time[0]);
        for (int i = 0; i < n; i++) {
            if (dir1[i] == true) {
                System.out.print(" 左");
            }
            else {
                System.out.print(" 右");
            }
        }
        System.out.print("\n最长时间：" + time[1]);
        for (int i = 0; i < n; i++) {
            if (dir2[i] == true) {
                System.out.print(" 左");
            }
            else {
                System.out.print(" 右");
            }
        }
    }
    public static void getSolution(int L, int n, int[] xi, boolean[] dir1, boolean[] dir2, int [] time) {
        time[0] = time[1] = 0;
        for (int i = 0; i < n; i++) {
            time[0] = Math.max(time[0], getMin(xi, i, L, dir1));
            time[1] = Math.max(time[1], getMax(xi, i, L, dir2));
        }
    }
    public static int getMax(int[] x, int i, int L, boolean[] dir) {
        if (x[i] > L - x[i]) {
            dir[i] = true;
            return x[i];
        }
        dir[i] = false;
        return L - x[i];
    }
    public static int getMin(int[] x, int i, int L, boolean[] dir) {
        if (x[i] > L - x[i]) {
            dir[i] = false;
            return L - x[i];
        }
        dir[i] = true;
        return x[i];
    }
}