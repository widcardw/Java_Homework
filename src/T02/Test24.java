package src.T02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;


// 字符的排列组合
public class Test24 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");

        Scanner input = new Scanner(System.in);
        char strArr[] = input.next().toCharArray();
        System.out.print("请输入一个整数：");
        int num = input.nextInt();
        input.close();

        Stack<Character> stack = new Stack<Character>();
        ArrayList<Vector<Character>> combinations = new ArrayList<Vector<Character>>();
        
        // 获取所有组合,存入combinations中
        getCombinations(strArr, 0, num, stack, combinations);  

        // System.out.println("全部组合\n" + combinations);
        System.out.println("全部组合");
        for (Vector<Character> vector : combinations) {
            for (char c : vector) {
                System.out.print(c);
            }
            System.out.println("");
        }
        
        System.out.println("全部排列");
        for (Vector<Character> vector : combinations) {
            // 对每个组合进行全排列
            getPermutation(vector, 0);  
        }
    }

    // 交换vector中的元素值
    public static void swap(Vector<Character> arr, int i, int j) {  
        Character temp = arr.elementAt(i);
        arr.setElementAt(arr.elementAt(j), i);
        arr.setElementAt(temp, j);
    }

    // 打印全排列
    public static void getPermutation(Vector<Character> arr, int i) {  
        // i从0开始
        // 交换结束, 对字符串进行打印输出
        if (i == arr.size()) {  
            // 按照题目中给定的格式 输出
            for (Character character : arr) {
                System.out.print(character);
            }
            System.out.println(""); 
            // 其实直接sysoutln格式差不多
            return;
        }
        for (int j = i; j < arr.size(); j++) {
            swap(arr, i, j);             // 交换i和j的元素, 得到另一种全排列
            getPermutation(arr, i + 1);  // 对i+1开始的字符串进行递归操作
            swap(arr, i, j);             // 对字符串顺序进行回溯
        }
    }
    public static void getCombinations(char[] str, int begin, int len, Stack<Character> stack, ArrayList<Vector<Character>> result) {
        if (len == 0) {
            // Vector<Character> temp = (Vector) stack.clone();  
            // result.add(temp);
            // 将stack的拷贝放入result中
            result.add((Vector) stack.clone()); 
            // 如果不拷贝, 最后stack都会清空
            return;
        }
        if (begin >= str.length) { return; }
        // 第一个字母入栈
        stack.push(str[begin]);  
        // 对剩下的字母进行操作(最终得到abc, abd, acd等)
        getCombinations(str, begin + 1, len - 1, stack, result); 
        // 第一个字母出栈
        stack.pop();  
        // 对第二个字母开始的字符串进行操作(对b开始的字符串进行操作, 得到bcd等)
        getCombinations(str, begin + 1, len, stack, result);  
    }
}