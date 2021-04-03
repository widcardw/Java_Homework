package src.T03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_04 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");
        Scanner input = new Scanner(System.in);
        String src = input.next();
        System.out.print("请输入作为子串用的字符串：");
        String sub = input.next();
        input.close();
        String result = bracketizeSubString(src, sub);
        System.out.println("结果是：" + result);
    }

    public static String bracketizeSubString(String src, String sub) {
        Pattern p = Pattern.compile(sub);
        Matcher m = p.matcher(src);
        src = m.replaceAll("[" + sub + "]");
        return src;
    }
}