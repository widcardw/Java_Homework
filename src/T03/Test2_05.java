package src.T03;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Test2_05 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个字符串: ");
        String src = input.nextLine();
        input.close();
        String reversed = reverse(src);
        System.out.println("结果是: " + reversed);
    }

    public static String reverse(String src) throws UnsupportedEncodingException {
        // byte[] brr = src.getBytes("GBK");
        // for (int b : brr) {
        //     System.out.println(b);
        // }
        // String result = "";
        // for (int i = 0; i < brr.length; i++) {
        //     result = (char) brr[i] + result;
        // }
        // return result;

        // TODO
        // 中文字符串支持还未实现 👈这个是看编码的
        // src = new String(src.getBytes("GB2312"), "GB2312");
        // System.out.println(src);
        // String result = "";
        // for (int i = 0; i < src.length(); i++) {
        //     result = src.charAt(i) + result;
        // }
        // return result;
        return new StringBuffer(src).reverse().toString();
    }
}