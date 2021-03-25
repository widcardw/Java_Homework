package src.T02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// 从键盘上输入一个字符串(句子)。
// 统计它当中的每一个英文单词出现的次数（单词大小写不区分）
public class Test26 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        String str = getInput();

        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        calWordFrequency(str, hashmap);
        
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(hashmap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int flag = -(o1.getValue() - o2.getValue());
                if (flag != 0) { return flag; }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String,Integer> entry : list) {
            System.out.println(entry.getKey() + "出现" + entry.getValue() + "次");
        }
        // System.out.println(hashmap);
    }
    public static String getInput() {
        Scanner input = new Scanner(System.in);
        String result = input.nextLine();
        input.close();
        return result.toLowerCase();
    }
    public static void calWordFrequency(String line, Map<String, Integer> map) {
        String words[] = line.split(" |,|:|'|\\.|\"");
        // for (String string : words) {
        //     System.out.println(string);
        // }
        for (String word : words) {
            if (!word.isEmpty()) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                }
                else {
                    map.put(word, map.get(word) + 1);
                }
            }
        }
    }
}