package src.T02;

import java.util.Scanner;


// 计算一个自然数，有多少种加表示法。要求输出每一种拆分方式
// TODO
// 还需要优化
// 以及把本身加进去
public class Test31 {
    static int total = 0;
    public static void main(String[] args) {
        System.out.print("请输入一个正整数：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        int[] pieces = new int[1000];
        splitNumber(n, 1, pieces);
        System.out.println("整数" + n + "共有" + total + "中拆分方法");
    }
    public static void splitNumber(int n, int process, int[] pieces) {
        int rest = n, i = 0, j = 0;
        for (i = 1; i <= n; ++i) {
            if (i >= pieces[process - 1]) {
                pieces[process] = i;
                rest = n - i;
                if (rest == 0 && process > 1) {
                    total++;
                    for (j = 1; j < process; j++) {
                        System.out.printf("%d+", pieces[j]);
                    }
                    System.out.println(pieces[j]);
                }
                else {
                    splitNumber(rest, process + 1, pieces);
                }
                pieces[process] = 0;
            }
        }
    }
}