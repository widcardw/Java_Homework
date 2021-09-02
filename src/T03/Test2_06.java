package src.T03;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_06 {
    public static void main(String[] args) {
        System.out.print("请输入分子式：");
        Scanner input = new Scanner(System.in);
        String fomula = input.next();
        input.close();
        double result = getMessOfChemistryFomula(fomula);
        System.out.println("分子式：" + fomula + " 的分子量为 " + result + " g/mol");
    }

    public static HashMap<String, Double> map = new HashMap<>();

    static {
        map.put("C", 12.01);
        map.put("H", 1.008);
		map.put("O", 16.00);
		map.put("N", 14.01);
    }

    public static double getMessOfChemistryFomula(String fomula) {
        double result = 0;

        Pattern p = Pattern.compile("([CHON])(\\d*)");
        Matcher m = p.matcher(fomula);
        while (m.find()) {
            String key = m.group(1);
            String snum = m.group(2);
            int num = 1;
            if (snum != null && snum.length() > 0) {
                num = Integer.parseInt(snum);
            }
            result += map.get(key) * num;
        }

        return result;
    }

    // public static double getMessOfChemistryFomula(String fomula) {
    //     double result = 0;

    //     Pattern p = Pattern.compile("[CHON](\\d*)");
    //     Matcher m = p.matcher(fomula);
    //     while(m.find()) {
    //         // System.out.println(m.group());
    //         switch (m.group().charAt(0)) {
    //             case 'C':
    //                 if (m.group().length() <= 1) {
    //                     result += 12.01;
    //                 }
    //                 else {
    //                     int num = Integer.parseInt(m.group().substring(1));
    //                     result += 12.01 * num;
    //                 }
    //                 break;
    //             case 'H':
    //                 if (m.group().length() <= 1) {
    //                     result += 1.008;
    //                 }
    //                 else {
    //                     int num = Integer.parseInt(m.group().substring(1));
    //                     result += 1.008 * num;
    //                 }
    //                 break;
    //             case 'O':
    //                 if (m.group().length() <= 1) {
    //                     result += 16.00;
    //                 }
    //                 else {
    //                     int num = Integer.parseInt(m.group().substring(1));
    //                     result += 16.00 * num;
    //                 }
    //                 break;
    //             case 'N':
    //                 if (m.group().length() <= 1) {
    //                     result += 14.01;
    //                 }
    //                 else {
    //                     int num = Integer.parseInt(m.group().substring(1));
    //                     result += 14.01 * num;
    //                 }
    //                 break;
    //         }
    //     }
    //     return result;
    // }
}
