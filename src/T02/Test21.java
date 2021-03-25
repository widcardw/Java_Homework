package src.T02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


// 输入若干个（如：10个）正整数值，找出其中的最大值，
// 输出：最大值、出现的次数、出现的位置。
// 然后重复找下一个最大值。直到这些个（如：10个）正整数处理完毕。
public class Test21 {
    public static void main(String[] args) {
        System.out.print("请输入数字的个数:");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.printf("请输入这%d个数:\n", n);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        Map<Integer, Vector<Integer>> map = new HashMap<Integer, Vector<Integer>>();
        getNumbers(arr, map);
        List<Map.Entry<Integer, Vector<Integer>>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Vector<Integer>>>() {
            public int compare(Map.Entry<Integer, Vector<Integer>> o1, Map.Entry<Integer, Vector<Integer>> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        
        for (Map.Entry<Integer,Vector<Integer>> entry : list) {
            System.out.printf("%d出现%d次, 位置在", entry.getKey(), entry.getValue().size());
            for (Integer i : entry.getValue()) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
    
    public static void getNumbers(int[] arr, Map<Integer, Vector<Integer>> map) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            }
            else {
                Vector<Integer> v = new Vector<Integer>();
                v.add(i);
                map.put(arr[i], v);
            }
        }
    }
}