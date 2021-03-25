package src.T02;

import java.util.Scanner;


//  输入三个正整数A、B和N（1<=N<=300），求A/B的值，要求小数点后精确到N位
public class Test36 {
    public static void main(String[] args) {
        System.out.println("请输入三个正整数A, B, N: ");
        Scanner input = new Scanner(System.in);
        String a = input.next(), b = input.next();
        int n = input.nextInt();
        input.close();

        String result = highPrecisionDivider(a, b, n);
        System.out.println(result);
    }
    public static String highPrecisionDivider(String a, String b, int precision) {
        String result = "";

        // 计算整数部分
        int exp = 0;
        while (compareValue(a, b)) {
            int low = 0; exp = 0; 
            String b_copy = b;  // 给 b 的末尾补零
            // 给b的末尾补零
            while (compareValue(a, b_copy + "0")) {
                b_copy += "0"; exp++;
            }
            // 计算高位
            while (compareValue(a, b_copy)) {
                a = substracter(a, b_copy);
                low++;
            }
            // 将高位上商到 result
            result += low;
        }
        // 如果商末尾有零, 就把0补上
        while (exp > 0) {
            exp--; result += "0";
        }
        // 如果 a < b, 那么先给 result 首位添个 0
        if (result.isEmpty()) {
            result = "0";
        }
        // 小数点
        result += ".";
        
        // 计算小数部分
        while (precision > 0) {
            // 清除a首位的0
            a = clearZerosInFront(a);
            int low = 0;
            // 如果a末尾添零比b小, 就一直添零
            while (compareValue(a, b) == false) {
                a += "0"; exp++;
            }
            while (exp > 1) {
                exp--; result += "0"; 
                precision--;
                if (precision <= 0) 
                    return result;
            }
            exp = 0;
            // 上商
            while (compareValue(a, b)) {
                a = substracter(a, b);
                low++;
            }
            result += low;
            precision--;
        }
        // 在此处并没用进行四舍五入的处理

        return result;
    }

    public static String substracter(String a, String b) {
        String result = "";

        int len = Math.max(a.length(), b.length());
        a = formatNumber(a, len);
        b = formatNumber(b, len);
        int low = 0;
        boolean flag = false;

        for (int i = len - 1; i >= 0; i--) {
            low = (int) (a.charAt(i) - '0') - (int) (b.charAt(i) - '0');
            if (flag) low--;
            flag = low < 0;
            if (flag) low += 10;
            result = low + result;
        }

        // 溢出问题和首位零问题....
        return result;
    }

    public static boolean compareValue(String a, String b) {
        int len = Math.max(a.length(), b.length());
        a = formatNumber(a, len);
        b = formatNumber(b, len);

        return a.compareTo(b) >= 0;
    }

    public static String formatNumber(String num, int len) {
        for (int i = num.length(); i < len; i++) {
            num = "0" + num;
        }
        return num;
    }

    public static String clearZerosInFront(String a) {
        int zeros = 0;
        while (a.charAt(zeros) == '0' && a.length() - zeros > 1) {
            zeros++;
        }
        return a.substring(zeros);
    }
}