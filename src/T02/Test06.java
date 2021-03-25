package src.T02;

import java.util.Scanner;


// 1-1/2+1/3-1/4+1/5-1/6+…..1/n
public class Test06 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        double sum = sumFractions(n);
        System.out.println("和="+sum);
    }
    public static double sumFractions(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i * oddAndEven2Sign(i);
        }
        return sum;
    }
    public static int oddAndEven2Sign(int i) {
        if (i % 2 == 0) return -1;
        return 1;
    }
}