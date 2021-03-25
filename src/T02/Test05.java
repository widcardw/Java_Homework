package src.T02;

import java.util.Scanner;


// 输出前n个质数，每行k个
public class Test05 {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数值（如：8   3）");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        input.close();
        printPrimes(n, k);
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
    public static void printPrimes(int n, int k) {
        int num = 2, count = 1;
        while (count <= n) {
            if (isPrime(num) == 1) {
                System.out.printf("%d ", num);
                if (count % k == 0) {
                    System.out.println("");
                }
                count++;
            }
            num++;
        }
    }
}