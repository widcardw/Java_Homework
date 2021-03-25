package src.T02;

import java.util.Scanner;


// 大数相乘，利用字符串
public class Test32 {
    public static int LIMITSIZE = 4;
    public static void main(String[] args) {
        System.out.println("请输入两个大正整数：");
        Scanner input = new Scanner(System.in);
        String a = input.next(), b = input.next();
        input.close();

        System.out.println("相乘结果是");
        String c = bigIntegerMultiplication(a, b);
        System.out.println(c);
    }

    public static String bigIntegerMultiplication(String a, String b) {
        // int len = Math.max(a.length(), b.length());
        String result = "0";
        String temp = "";

        // a = formatNumber(a, len);
        // b = formatNumber(b, len);  // 高位补零

        for (int i = 0; i < b.length(); i++) {
            temp = multiplier1Bit(a, b.charAt(i));
            result = adder(result + "0", temp);
        }

        return result;
    }

    public static String formatNumber(String num, int len) {
        for (int i = num.length(); i < len; i++) {
            num = "0" + num;
        }
        return num;
    }

    public static String adder(String a, String b) {
        String result = "";
        boolean carryFlag = false;
        int low = 0;

        int len = Math.max(a.length(), b.length());
        a = formatNumber(a, len);
        b = formatNumber(b, len);

        for (int i = a.length() - 1; i >= 0; i--) {
            low = Integer.parseInt(a.substring(i, i + 1)) + Integer.parseInt(b.substring(i, i + 1));
            if (carryFlag == true) low++;
            if (low >= 10) {
                carryFlag = true; low -= 10;
            }
            else 
                carryFlag = false;
            result = low + result;
        }
        if (carryFlag) result = "1" + result;
        return result;
    }

    public static String multiplier1Bit(String a, char b) {
        String result = "";
        int low = 0;
        int flag = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            low = flag + Integer.parseInt(a.substring(i, i + 1)) * (int) (b - '0');
            flag = low / 10;
            low %= 10;
            result = low + result;
        }
        if (flag != 0) { result = flag + result; }

        return result;
    }

    public static String multiAdder(String[] arr, int len) {
        int flag = 0;
        String result = "";
        for (int j = 0; j < len; j++) {
            int low = 0;
            for (int i = 0; i < arr.length; i++) {
                low += Integer.parseInt(arr[i].substring(len - j - 1, len - j));
                // System.out.println(low);
            }
            low += flag;
            flag = low / 10;
            low %= 10;
            result = low + result;
        }
        if (flag != 0) {
            result = flag + result;
        }
        return result;
    }
}