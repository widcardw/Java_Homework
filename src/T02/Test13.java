package src.T02;

import java.util.Scanner;


// 输入一个正整数n, 先计算出它的逆序数值，然后再输出逆序数值
public class Test13 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        System.out.println(getReversedNumber(n));
    }
    public static int getReversedNumber(int n) {
        int result = 0, x = 0;
        while (true) {
            x = n % 10;   // 取末位数
            result += x;  // result加上最后一位数
            n /= 10;      // n除以10
            if (n == 0) { break; }  // 如果n==0，跳出循环
            result *= 10; // n!=0，继续循环，result位数变高
        }
        return result;
    }
}