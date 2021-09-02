package src.T03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_07_2 {
    public static void main(String[] args) {
        String abc = "abcabcabcabc";
        for (int i = 1; i <= abc.length(); i++) {
            String sub = abc.substring(0, i);
            Pattern p = Pattern.compile("(" + sub + ")" + "(\\1)*");
            Matcher m = p.matcher(abc);
            if (m.matches()) {
                System.out.println("周期串:" + sub + ", 长度:" + sub.length());
            }
        }
    }
}