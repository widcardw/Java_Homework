package src.T03;

import java.util.Scanner;

public class Test2_01 {
    // public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);
    // System.out.print("请输入原进制：");
    // int k = input.nextInt();
    // System.out.print("该进制的数值串：");
    // String src = input.next();
    // System.out.print("请输入目标进制：");
    // int m = input.nextInt();
    // input.close();
    // String result = parseKtoM(src, k, m);
    // if (result.isEmpty()) {
    // System.out.printf("%s是非法的%d进制数!\n", src, k);
    // }
    // else {
    // System.out.printf("%d进制数%s转换成%d进制结果是: %s\n", k, src, m, result);
    // }
    // }

    // public static String parseKtoM(String src, int srcRadix, int destRadix) {
    // int real_value = 0;
    // for (int i = 0; i < src.length(); i++) {
    // int val = src.charAt(i) - '0';
    // if (val >= srcRadix) {
    // return "";
    // }
    // real_value *= srcRadix;
    // real_value += val;
    // }
    // String dest = "";
    // while (real_value > 0) {
    // int val = real_value % destRadix;
    // real_value /= destRadix;
    // dest = val + dest;
    // }
    // return dest;
    // }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入原进制：");
        int k = input.nextInt();
        System.out.print("该进制的数值串：");
        String src = input.next();
        System.out.print("请输入目标进制：");
        int m = input.nextInt();
        input.close();
        String result = parseKtoM(src, k, m);
        if (result != null) {
            System.out.printf("%d进制数%s转换成%d进制结果是: %s\n", k, src, m, result);
        }
    }

    public static String parseKtoM(String src, int k, int m) {
        String result = null;
        try {
            int i = Integer.parseInt(src, k);
            result = Integer.toString(i, m);
        } catch (NumberFormatException e) {
            System.out.println("非法数字");
        }
        return result;
    }
}
