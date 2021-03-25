package src.T02;

import java.util.Scanner;


// a+aa+aaa+aaaa+aa…a(最后一项是n个a)的值，其中a和n 从键盘输入
public class Test08 {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数值：");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), n = input.nextInt();
        input.close();
        System.out.println("和=" + sumNas(a, n));
    }
    public static int sumNas(int a, int n) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 10 + a;
            sum += ans;
        }
        return sum;
    }
}