package src.T02;

import java.util.Scanner;


// 输入正整数n和正整数k,输出n从右边开始第k个数字的值
public class Test15 {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数：");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        input.close();

        System.out.println(getLastKNumberOfN(n, k));
    }
    public static int getLastKNumberOfN(int n, int k) {
        for (int i = 0; i < k - 1; i++) {
            n /= 10;
        }
        return n % 10;
    }
}