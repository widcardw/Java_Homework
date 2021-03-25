package src.T02;

import java.util.Scanner;


// 从键盘上读入一个非负整数，屏幕上输出这上整数的倒序的十进制数
// (2456 ,0)->(245,6)->(24,65)->(2,654)->(0,6542)->6542
public class Test30 {
    public static void main(String[] args) {
        System.out.print("请输入一个正整数: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        System.out.println(n + "的倒序是" + reverse(n));
    }
    // 好像只用一个函数来实现有点困难, 所以就用了重载
    public static int reverse(int m, int n) {  
        if (m == 0) return n;
        return reverse(m / 10, n * 10 + m % 10);
    }
    public static int reverse(int n) {
        return reverse(n, 0);
    }
}