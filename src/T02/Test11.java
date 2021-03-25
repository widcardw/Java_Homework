package src.T02;

import java.util.Scanner;


// 输入一个正整数n, 计算s=1!+3!+5!+…+n!。
// 若n是奇数，则计算到n!。若n是偶数，则计算到(n-1)!

public class Test11 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        int s1 = getSumOfOddFactorial(n);
        int s2 = getSumOfFactorial(n);
        System.out.println("s1=" + s1);
        System.out.println("s2=" + s2);

    }
    public static int getSumOfOddFactorial(int n) {
        int sum = 0; int ans = 1; int i = 1;
        while (true) {
            sum += ans;
            i += 2;
            if (i > n) 
                break;
            ans *= (i - 1) * i;
        }
        return sum;
    }
    public static int getSumOfFactorial(int n) {
        int sum = 0, ans = 1, i = 1;
        while (true) {
            sum += ans;
            i++;
            if (i > n)
                break;
            ans *= i;
        }
        return sum;
    }
}