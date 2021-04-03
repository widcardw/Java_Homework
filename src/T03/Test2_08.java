package src.T03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_08 {
    public static void main(String[] args) {
        System.out.print("请输入模板串：");
        Scanner input = new Scanner(System.in);
        String fomula = input.nextLine();
        // System.out.println(fomula);
        System.out.print("请输入数据源串：");
        String data = input.nextLine();
        input.close();

        Map<String, String> map = new HashMap<String, String>();
        getData(data, map);
        String result = getValue(fomula, map);
        System.out.println(result);
    }

    public static void getData(String src, Map<String, String> map) {
        String[] key_value = src.split(",");
        for (String string : key_value) {
            String[] pair = string.split(":");
            map.put(pair[0], pair[1]);
        }
        // System.out.println(map);
    }

    public static String getValue(String template, Map<String, String> map) {
        Pattern p = Pattern.compile("\\$\\{.*?\\}");
        Matcher m = p.matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String param = m.group();
            Object value = map.get(param.substring(2, param.length() - 1));
            // System.out.println(param + " " + value);
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }
}