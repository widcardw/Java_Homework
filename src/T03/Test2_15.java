package src.T03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] src = new String[n];
        for (int i = 0; i < n; i++) {
            src[i] = scanner.next();
        }
        scanner.close();
        for (int i = 0; i < n; i++) {
            System.out.println(enCrypto(src[i]));
        }
    }

    public static String enCrypto(String src) {
        List<String> list = new ArrayList<String>();
        getStringList(src, list);
        int[] arr = new int[6];
        getAsciiSum(list, arr);
        for (int i = 0; i < 6; i++) {
            arr[i] = shrinkInteger(arr[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void getStringList(String src, List<String> list) {
        for (int i = 0; i < src.length(); i += 6) {
            String ss = "";
            if (i + 6 >= src.length()) {
                ss = src.substring(i);
            }
            else {
                ss = src.substring(i, i + 6);
            }
            list.add(ss);
        }
    }

    public static void getAsciiSum(List<String> list, int[] arr) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).length() <= i) 
                    continue;
                arr[i] += (int) list.get(j).charAt(i);
            }
        }
    }

    public static int shrinkInteger(int x) {
        if (x >= 0 && x < 10) { return x; }
        int result = 0;
        while (x > 0) {
            result += x % 10;
            x /= 10;
        }
        return shrinkInteger(result);
    }
}