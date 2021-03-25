package src.T02;

import java.util.Scanner;


// 今盒子里有n个小球，A、B两人轮流从盒中取球，
// 每个人都可以看到另一个人取了多少个，也可以看到盒中还剩下多少个，
// 并且两人都很聪明，不会做出错误的判断。
// 我们约定：    
// 每个人从盒子中取出的球的数目必须是：1，3，7或者8个。
// 轮到某一方取球时不能弃权！
// A先取球，然后双方交替取球，直到取完。
// 被迫拿到最后一个球的一方为负方（输方）
// 请编程确定出在双方都不判断失误的情况下，对于特定的初始球数，A是否能赢？
public class Test35 {
    public static void main(String[] args) {
        System.out.print("初始球数=");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        boolean win = solve(n);
        if (win) {
            System.out.println("A赢");
        }
        else {
            System.out.println("A输");
        }
    }
    public static boolean solve(int n) {
        if (n >= 1) {
            switch (n) {
                case 1: return false;
                case 2: return true;
                case 3: return false;
                case 4: return true;
                case 5: return false;
                case 6: return true;
                case 7: return false;
                case 8: return true;
                default:
                    return (!solve(n - 8) | !solve(n - 7) | !solve(n - 3) | !solve(n - 1));
            }
        }
        return false;
    }
}