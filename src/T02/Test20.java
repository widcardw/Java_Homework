package src.T02;

import java.util.Scanner;


//  计算多项式P(x)=a_0+a_1x+a_2x^2+a_3x^3+…+a_{n-1}x^(n-1)+a_nx^n的值
public class Test20 {
    public static void main(String[] args) {
        System.out.print("N=");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double a[] = new double[n + 1];

        System.out.println("请输入" + (n + 1) + "个系数(实数)：");
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextDouble();
        }
        System.out.println("请输入变量x的值(实数)：");
        double x = input.nextDouble();
        input.close();

        double result = getFormulaValue(a, x);
        System.out.print("P(x)=" + result);
    }
    public static double getFormulaValue(double a[], double x) {
        double result = 0;
        double ans_x = 1;
        for (int i = 0; i < a.length; i++) {
            result += ans_x * a[i];
            ans_x *= x;
        }
        return result;
    }
}