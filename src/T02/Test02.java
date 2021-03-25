package src.T02;

import java.util.Scanner;


// 输出i~j之间(含i和j)所有的整数值，每行k个
public class Test02 {
    public static void main(String[] args) {        
        System.out.println("请输入三个正整数（如3，4，20）：");

        Scanner input = new Scanner(System.in);
        int i = input.nextInt(), k = input.nextInt(), j = input.nextInt();
        input.close();
        printRangeI2JperLineK(i, j, k);
    }
    public static void printRangeI2JperLineK(int i, int j, int k) {
        for (int m = i; m <= j; m++) {
            System.out.printf("%d ", m);
            if ((m - i + 1) % k == 0) {
                System.out.println("");
            }
        }
    }
}