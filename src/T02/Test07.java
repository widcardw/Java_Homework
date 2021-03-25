package src.T02;

import java.util.Scanner;


// Fibonacci
public class Test07 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        System.out.println("F" + n + "的值为" + fibonaci(n));
    }
    public static int fibonaci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonaci(n - 1) + fibonaci(n - 2);
    }
}