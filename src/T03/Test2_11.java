package src.T03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个串：");
        String src = input.nextLine();
        input.close();
        Map<String, String> map = new HashMap<String, String>();
        getMap(src, map);
        printValues(map);
    }

    public static void getMap(String src, Map<String, String> map) {
        String[] data = src.split("\\s");
        for (String string : data) {
            if (string.isEmpty()) continue;
            String[] pair = string.split("=");
            map.put(pair[0], pair[1]);
        }
    }

    public static void printValues(Map<String, String> map) {
        for (Map.Entry<String, String> it : map.entrySet()) {
            System.out.print(it.getValue() + "\t");
        }
    }
}