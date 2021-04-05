package src.T03;

import java.util.Scanner;
import java.util.Stack;

public class Test3_03 {
    public static void main(String[] args) {
        System.out.println("请输入两个字符串");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.next();
        String dest = scanner.next();
        scanner.close();
        Stack<Character> stack = new Stack<>();
        boolean[] flag = { false };
        getSolution(src.toCharArray(), dest.toCharArray(), 0, 0, stack, flag);
        if (flag[0])
            System.out.println("可以");
        else
            System.out.println("不可以");
    }

    // 依然是回溯法, 复杂度高, 而且好像stack在这里没用?
    public static void getSolution(char[] src, char[] dest, int m, int n, Stack<Character> stack, boolean[] flag) {
        if (n >= dest.length) {
            flag[0] = true;
            return;
        }
        for (int i = m, j = n; i < src.length && j < dest.length && flag[0] == false; i++) {
            if (src[i] == dest[j]) {
                stack.push(src[i]);
                j++; i++;
                getSolution(src, dest, i, j, stack, flag);
                stack.pop();
            }
        }
    }
}