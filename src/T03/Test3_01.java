package src.T03;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Test3_01 {
    public static void main(String[] args) {
        System.out.print("请输入黑子的数量: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        Stack<Stack<Vector<String>>> solutions = new Stack<>();
        Stack<Vector<String>> way = new Stack<>();  // 好像可以用char? 因为只有一个汉字?
        crossTheRiver(n, n, n, solutions, way);
        int count = solutions.size();
        System.out.printf("一共有%d种渡河方案\n", count);
        for (int i = 0; i < count; i++) {
            System.out.println("第" + (i + 1) + "种: " + solutions.get(i));
        }
    }

    // 回溯法, 复杂度真的很高, 但我只会用这种方法
    public static void crossTheRiver(
        int n, int white, int black, 
        Stack<Stack<Vector<String>>> solutions, 
        Stack<Vector<String>> way
    ) {
        if (white <= 0 && black <= 0) {
            solutions.push((Stack<Vector<String>>) way.clone());
            return;
        }
        if ((white < black && white > 0) || 
            ((n - white) < (n - black) && (n - white) > 0) ||
            (white < 0) || (black < 0)
        ) {
            return;
        }
        if (white > 0 && black > 0){
            Vector<String> v = new Vector<>();
            v.add("黑"); v.add("白"); 
            way.push(v);
            crossTheRiver(n, white - 1, black - 1, solutions, way);
            way.pop();
        }
        if (black > 0){
            Vector<String> v = new Vector<>();
            v.add("黑");
            way.push(v);
            crossTheRiver(n, white, black - 1, solutions, way);
            way.pop();
        }
        if (white > 0){
            Vector<String> v = new Vector<>();
            v.add("白");
            way.push(v);
            crossTheRiver(n, white - 1, black, solutions, way);
            way.pop();
        }
        if (black > 1) {
            Vector<String> v = new Vector<>();
            v.add("黑"); v.add("黑");
            way.push(v);
            crossTheRiver(n, white, black - 2, solutions, way);
            way.pop();
        }
        if (white > 1) {
            Vector<String> v = new Vector<>();
            v.add("白"); v.add("白");
            way.push(v);
            crossTheRiver(n, white - 2, black, solutions, way);
            way.pop();
        }
    }
}