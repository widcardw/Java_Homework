package src.T02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// 通过Scanner类输入一个英文ASCII的字符串
// 统计它当中的每一个字符出现的次数
public class Test22 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner input = new Scanner(System.in, "utf-8");
        String str = input.nextLine();
        input.close();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        getCharMap(str, map);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Character,Integer> entry : list) {
            System.out.println("字符" + entry.getKey() + "出现" + entry.getValue() + "次");
        }
    }
    public static void getCharMap(String str, Map<Character, Integer> m) {
        for (int i = 0; i < str.length(); i++) {
            byte b = str.getBytes()[i];  // 转换成字节再转成字符中文还是会有乱码
            char ch = (char) b;
            // System.out.println(b);
            if (m.get(ch) != null) {
                int count = m.get(ch);
                m.put(ch, count + 1);
            }
            else {
                m.put(ch, 1);
            }
        }
    }
}