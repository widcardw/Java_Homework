package src.T03;

import java.util.Scanner;

public class Test3_04 {
    // 有n（n≤100）个人，把他们分成非空的两组，
    // 使得每个人都被分到一组，且同组中的人相互认识。
    // 要求两组的成员人数尽量接近。
    // 多解时输出任意方案，无解时输出No Solution。
    //
    // 难度较大, 暂时没做
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " 认识");
            String ss = scanner.nextLine();
            String[] sp = ss.split("\\D+");
            for (int j = 0; j < sp.length; j++) {
                arr[i][Integer.parseInt(sp[j])] = true;
            }
        }
        scanner.close();
        for (boolean[] bs : arr) {
            for (boolean bs2 : bs) {
                System.out.print(" " + bs2);
            }
            System.out.println("");
        }
    }

    public static void getSolution(boolean[][] arr) {
        
    }
}