package src.T02;

import java.util.Scanner;


// 递归求和
public class Test27 {
    public static void main(String[] args) {
        System.out.print("请输入一个正整数: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        int sum = sumNaturalNumbers(n);
        System.out.println("和=" + sum);
    }
    public static int sumNaturalNumbers(int n) {
        if (n == 0) return 0;
        return sumNaturalNumbers(n - 1) + n;
    }
}