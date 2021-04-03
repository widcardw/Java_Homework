package src.T03;

import java.util.Scanner;

public class Test2_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] srr = new String[n];
        for (int i = 0; i < n; i++) {
            srr[i] = input.next();
        }
        input.close();
        for (int i = 0; i < n; i++) {
            System.out.println(translateRCtoNormal(srr[i]));
        }
    }

    public static String translateRCtoNormal(String src) {
        String result = "";
        int index_c = src.indexOf("C");
        int row = Integer.parseInt(src.substring(1, index_c));
        int col = Integer.parseInt(src.substring(index_c + 1));
        while (col > 0) {
            char ch = (char) ('A' + col % 26 - 1);
            result = ch + result;
            col /= 26;
        }
        result += row;
        return result;
    }
}