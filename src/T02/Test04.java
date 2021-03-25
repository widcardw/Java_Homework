package src.T02;

import java.util.Scanner;


// 输出i~j之间所有的质数，每行k个
public class Test04 {
    public static void main(String[] args) {
        System.out.println("请输入三个正整数值（如：5   18   3）");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt(), j = input.nextInt(), k = input.nextInt();
        input.close();
        printPrimesInRangeI2J(i, j, k);
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
    public static void printPrimesInRangeI2J(int i, int j, int k) {
        int count = 0;
        for (int m = i; m <= j; m++) {
            if (isPrime(m) == 1) {
                System.out.printf("%d ", m); count++;
                if (count % k == 0) {
                    System.out.println("");
                }
            }
        }
    }
}