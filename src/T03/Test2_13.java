package src.T03;

import java.util.Scanner;

public class Test2_13 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");
        Scanner scanner = new Scanner(System.in);
        String src = scanner.next();
        scanner.close();
        String result = compresString(src);
        System.out.println("压缩后的结果是：" + result);
    }
    public static String compresString(String src) {
        String result = "";

        int count;
        for (int i = 0; i < src.length(); i++) {
            count = 0;
            int j;
            for (j = i; j < src.length(); j++) {
                if (src.charAt(i) == src.charAt(j)) {
                    count++;
                }
                else {
                    break;
                }
            }
            result += src.charAt(i);
            if (count > 1) {
                result += count;
            }
            i = j - 1;
        }

        return result;
    }
}