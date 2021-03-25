package src.T02;

import java.util.Scanner;


// 使用递归实现如下的方法：著名的“Ackman”方法
// Ack(0,n)=n+1                  当n>=0时
// Ack(m,0)=Ack(m-1,1)           当m>=1时
// Ack(m,n)=Ack(m-1,Ack(m,n-1))  当m和n都>=1时

public class Test29 {
    public static void main(String[] args) {
        System.out.print("请输入两个正整数: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        input.close();

        int acm = Acm(a, b);
        System.out.printf("Acm(%d, %d)=%d\n", a, b, acm);
    }
    public static int Acm(int m, int n) {
        if (m >= 1 && n == 0) return Acm(m - 1, 1);
        if (m >= 1 && n >= 1) return Acm(m - 1, Acm(m, n - 1));
        return n + 1;
    }
}