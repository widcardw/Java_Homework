package src.T03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_09_1 {
    public static void main(String[] args) {
        String ss = "R5C255";
        String st = trans(ss);
        System.out.println(st);
    }

    public static String trans(String src) {
        String result = "";
        Pattern p = Pattern.compile("R(\\d+)C(\\d+)");
        Matcher m = p.matcher(src);
        if (m.matches()) {
            int row = Integer.parseInt(m.group(1));
            int col = Integer.parseInt(m.group(2));
            while (col > 0) {
                char ch = (char) ('A' + col % 26 - 1);
                col /= 26;
                result += ch;
            }
            result += row;
        }
        return result;
    }
}