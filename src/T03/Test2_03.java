package src.T03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_03 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串: ");
        Scanner input = new Scanner(System.in);
        String src = input.next();
        input.close();
        int sum = getSumOfIntegers(src, true);
        System.out.println("和=" + sum);
    }

    public static int getSumOfIntegers(String src, boolean max4bit) {
        int sum = 0;
        Pattern p = Pattern.compile("\\d+");
        if (max4bit) p = Pattern.compile("\\d{1,4}");
        Matcher m = p.matcher(src);
        while (m.find()) {
            sum += Integer.parseInt(m.group());
        }
        return sum;
    }

    // public static int getSumOfIntegers(String src, boolean max4bit) {
    //     int sum = 0;
    //     String[] arr = src.split("\\D");  // 按非数字拆分
    //     for (String string : arr) {
    //         if (string.isEmpty()) continue;
    //         if (max4bit) 
    //             sum += sumLongNumbersBy4bit(string);
    //         else
    //             sum += Integer.parseInt(string);
    //     }
    //     return sum;
    // }

    // // 将较长的数字字符串按最长4位拆分
    // public static int sumLongNumbersBy4bit(String src) {
    //     int sum = 0, i = 0;
    //     while (i + 4 <= src.length()) {
    //         sum += Integer.parseInt(src.substring(i, i + 4));
    //         i += 4;
    //     }
    //     if (i >= src.length()) {
    //         return sum;
    //     }
    //     return sum + Integer.parseInt(src.substring(i, src.length()));
    // }
}