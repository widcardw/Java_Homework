package src.T02;

import java.util.Scanner;


// 计算一个自然数，有多少种加表示法，利用递归
public class Test34 {
    public static int total = 0;
    public static void main(String[] args) {
        System.out.print("请输入一个正整数");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        splitNumber(n);
        System.out.printf("共%d种表示方法\n", total);
    }
    public static void splitNumber(int n) {
        int[] arr = new int[100];
        System.out.println(n);
        total++;
        for (int i = 1; i <= n / 2; i++) {
            arr[0] = i;
            arr[1] = n - i;
            split(2, arr);
        }
    }
    public static void split(int n, int[] arr) {
        int i, j, l;
        for (i = 0; i < n - 1; i++) {
            System.out.printf("%d+", arr[i]);
        }
        System.out.printf("%d\n", arr[i]);
        total++;

        j = n;
        l = arr[j - 1];

        for (i = arr[j - 2]; i <= l / 2; i++) {
            arr[j - 1] = i;
            arr[j] = l - i;
            split(j + 1, arr);
        }
    }
}