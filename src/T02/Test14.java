package src.T02;

import java.util.Scanner;


// 输出给定范围之内的所有的同构数，每行10个
// 同构数是：它出现在其平方数的右边。如：5的平方是25，而5出现在25的右边。故5是同构数。
public class Test14 {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数：");

        Scanner input = new Scanner(System.in);
        int i = input.nextInt(), j = input.nextInt();
        input.close();

        System.out.printf("%d~%d之内的同构数有：\n", i, j);
        getIsomorphicNumbersInRange(i, j);
    }
    public static void getIsomorphicNumbersInRange(int min, int max) {
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (isIsomorphicNumber(i)) {
                System.out.printf("%d ", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println("");
                }
            }
        }
    }
    public static boolean isIsomorphicNumber(int n) {
        int n_square = n * n;
        int n_last = 0, n_square_last = 0;
        boolean flag = true;
        while (n != 0) {
            n_last = n % 10; n /= 10;
            n_square_last = n_square % 10; n_square /= 10;

            if (n_last != n_square_last) {
                flag = false; break;
            }
        }
        return flag;
    }
}