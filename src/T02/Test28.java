package src.T02;

import java.util.Scanner;


// 递归求最大公约数
public class Test28 {
    public static void main(String[] args) {
        System.out.print("请输入两个正整数: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        input.close();

        int c = gcd(a, b);

        System.out.println("最大公约数是" + c);
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}