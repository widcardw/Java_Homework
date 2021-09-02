package src.T03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_07_1 {
    public static void main(String[] args) {
        String abc = "abcabcabcabc";
        Pattern p = Pattern.compile("(.+?)(\\1)*");
        Matcher m = p.matcher(abc);

        if (m.matches()) {
            String sub = m.group(1);
            System.out.println("最小周期串为:" + sub + ", 长度为:" + sub.length());
        }
    }
}