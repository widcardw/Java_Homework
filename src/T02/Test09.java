package src.T02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


// 输出整数i~j之间的所有的完全数
// 所谓完全数，就是它等于除了自身外的其它的所有的因子之和
public class Test09 {
    public static void main(String[] args) {
        System.out.println("请输入两个正整数：");

        Scanner input = new Scanner(System.in);
        int i = input.nextInt(), j = input.nextInt();
        input.close();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        getComprehensiveNumbers(i, j, arr);

        System.out.println(i + "~" + j + "之间所有的完全数：");
        for (Integer k : arr) {
            System.out.print(k + " ");
        }
    }
    public static void getComprehensiveNumbers(int min, int max, ArrayList<Integer> arr) {
        Set<Integer> brr = new HashSet<Integer>();  // 因子互不相同，采用集合存储
        for (int i = min; i <= max; i++) {
            brr.clear();
            int sum = 0;
            getGenes(i, brr);
            for (Integer j : brr) {
                sum += j;
            }
            if (sum == i)
                arr.add(i);
        }
    }
    public static void getGenes(int x, Set<Integer> brr) {
        for (int i = 1; i <= x / 2; i++) {  // 复杂度好像很高，1~100k要跑好几秒
            if (x % i == 0)                 // 好像这种算法用 set 和用 arraylist 没区别？
                brr.add(i);
        }
    }
}