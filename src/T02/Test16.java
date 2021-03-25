package src.T02;

import java.util.Scanner;


// 输入一个正整数n，输出最接近它的素数
public class Test16 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        printNearestPrime(n);
    }
    public static int isPrime(int x) {
        if (x <= 1) { return 2; }
        int sqrt_x = (int) Math.sqrt(x);
        int flag = 1;
        for (int i = 2; i <= sqrt_x; i++) {
            if (x % i == 0) {
                flag = 0; break;
            }
        }
        return flag;
    }
    public static void printNearestPrime(int n) {
        if (isPrime(n) == 1) {
            System.out.printf("最接近%d的素数是：%d\n", n, n);
            return;
        }
        int d = 1, candidate1 = 0, candidate2 = 0;
        boolean flag = false;
        while (true) {
            if (isPrime(n - d) == 1) {
                candidate1 = n - d;
                flag = true;
            }
            if (isPrime(n + d) == 1) {
                candidate2 = n + d;
                flag = true;
            }
            if (flag) {
                if (candidate1 != 0 && candidate2 != 0) {
                    System.out.printf("最接近%d的素数是：%d, %d\n", n, candidate1, candidate2);
                }
                else {
                    System.out.printf("最接近%d的素数是：%d\n", n, candidate1 | candidate2);
                }
                return;
            }
            d++;
        }
    }
}