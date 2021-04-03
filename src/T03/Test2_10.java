package src.T03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String src = input.nextLine();
        input.close();
        System.out.println(reverseLetters(src));
    }

    public static String reverse(String src) {
        String result = "";
        for (int i = 0; i < src.length(); i++) {
            result = src.charAt(i) + result;
        }
        return result;
    }

    public static String reverseLetters(String src) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(src);
        while (m.find()) {
            String param = m.group();
            m.appendReplacement(sb, reverse(param));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}