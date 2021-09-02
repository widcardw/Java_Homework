package src.T03;

// import java.util.Scanner;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

public class Test2_02 {
    // public static void main(String[] args) {
    //     System.out.print("请输入字符串: ");
    //     Scanner input = new Scanner(System.in);
    //     String src = input.next();
    //     input.close();
    //     String compressed = compressString(src);
    //     System.out.println("压缩结果是: " + compressed);
    // }
    // // TODO 特殊符号的匹配, 目前还不能匹配括号!!!
    // // 👆对于括号单独处理了, 但对于其他符号还没有做
    // public static String compressString(String src) {
    //     int i = 0;
    //     while (true) {
    //         String ch = src.substring(i, i + 1);
    //         if (ch.charAt(0) == '(' || ch.charAt(0) == ')') {
    //             ch = "\\" + ch;
    //         }
    //         Pattern p = Pattern.compile(ch + "{1,}");
    //         Matcher m = p.matcher(src);
    //         src = m.replaceAll(ch);
    //         i++;
    //         if (i >= src.length())
    //             break;
    //     }
    //     return src;
    // }

    public static void main(String[] args) {
        String ss = "aaabbcddd112233((55))";
        String rs = ss.replaceAll("(.)(\\1)*", "$1");
        System.out.println("-->" + rs);
    }
}