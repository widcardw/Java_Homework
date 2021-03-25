package src.T02;

import java.util.Scanner;


// i+(i+k)+(i+2*k)+(i+3*k)…+j之和
public class Test01 {
    public static void main(String[] args) {
        System.out.println("请输入三个正整数（如3，4，20）：");
        
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        int k = input.nextInt();
        int j = input.nextInt();
        input.close();
        int sum = sumRangeI2JstepK(i, j, k); // 调用函数
        System.out.printf("%d", i);
        while (true) {
            i += k;
            if (i > j) { break; }
            System.out.printf("+%d", i);
        }
        System.out.printf("=%d\n", sum);
    }
    public static int sumRangeI2JstepK(int i, int j, int k) {
        if (i > j) {
            System.err.println("Input error! i > j !");
            return 0;
        }
        int m = i, sum = 0;
        for (m = i; m <= j; m += k) {
            sum += m;
        }
        return sum;
    }
}