package src.T02;

import java.util.Scanner;


// 输入一个正整数。若它是质数，则输出“是质数”，否则输出"不是质数"。
public class Test03 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数值:");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        input.close();
        if (isNotPrime(x)) {
            System.out.println("不是质数");
        }
        else {
            System.out.println("是质数");
        }
    }
    public static boolean isNotPrime(int x) {
        boolean flag = false;
        int sqrt_x = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrt_x; i++) {
            if (x % i == 0) {
                flag = true; break;
            }
        }
        return flag;
    }
}