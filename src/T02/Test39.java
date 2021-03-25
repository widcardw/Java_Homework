package src.T02;

import java.util.Scanner;
import java.util.Stack;


// 有n种不同大小的数字ai；每一种数字各有mi个，判断能否从这些数字之中选出若干种数字，使得它们的和正好为K
// 复杂度、重复率极高，直接TLE、RTE或者WA的一声哭出来好吧
public class Test39 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入n的值：");
        int n = input.nextInt();
        System.out.print("请输入各个ai的值：");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.print("请输入各个mi的值：");
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = input.nextInt();
        }
        System.out.print("请输入K值：");
        int K = input.nextInt();
        input.close();
        Stack<Integer> stack = new Stack<>();
        boolean[] flag = new boolean[1];
        flag[0] = false;

        getSolution(a, m, K, n, stack, flag);
        if (flag[0] == false) { 
            System.out.println("不能组成");
        }
        else {
            System.out.print("可以组成，方法：");
            System.out.print(stack.elementAt(0));
            for (int i = 1; i < stack.size(); i++) {
                System.out.printf("+%d", stack.elementAt(i));
            }
            System.out.println("=" + K);
        }
    }
    public static void getSolution(
        int[] a, int[] m, int K, int n, 
        Stack<Integer> stack, boolean[] flag
    ) {
        if (K < 0) return;
        for (int i = 0; i < n; i++) {
            if (m[i] < 0)
                return;
        }
        if (K == 0) {
            // System.out.println(stack);
            flag[0] = true;
            return;
        }
        for (int i = 0; i < n; i++) {
            stack.push(a[i]); K -= a[i]; m[i]--;
            getSolution(a, m, K, n, stack, flag);
            if (flag[0] == true) 
                return;
            stack.pop(); K += a[i]; m[i]++;
        }
    }
}