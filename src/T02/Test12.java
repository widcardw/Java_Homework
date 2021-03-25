package src.T02;

import java.util.Scanner;


// 输入一个正整数n, 输出它的各位数字的平方和
public class Test12 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        System.out.println("各位数字的平方和=" + getSquareSumOfEachDigit(n));
    }
    public static int getSquareSumOfEachDigit(int n) {
        int x = 0, sum = 0;
        while (n != 0) {
            x = n % 10;
            sum += x * x;
            n /= 10;
        }
        return sum;
    }
}