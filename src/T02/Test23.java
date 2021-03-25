package src.T02;

import java.util.Scanner;


// 通过Scanner类输入一个字符串，判是不是回文
public class Test23 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");

        Scanner input = new Scanner(System.in);
        String str = input.next();
        input.close();

        boolean is_palindrome = isPalindrome(str);
        if (is_palindrome) {
            System.out.println("字符串" + str + "是一个回文！");
        }
        else {
            System.out.println("字符串" + str + "不是一个回文！");
        }
    }
    public  static boolean isPalindrome(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                flag = false; break;
            }
        }
        return flag;
    }
}