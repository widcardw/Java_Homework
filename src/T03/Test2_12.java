package src.T03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test2_12 {
    public static void main(String[] args) {
        System.out.print("请输入表达式：");
        Scanner input = new Scanner(System.in);
        char[] src = input.nextLine().toCharArray();
        input.close();
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < src.length; i++) {
            list.add(src[i]);
        }
        // getFomula(list);
        simplifyFomula(list);
        String result = list.toString();
        System.out.println(result);
    }

    // TODO 还没写完呢, 没法把括号全删掉, 打算用 stack 操作重新写
    public static List<Character> simplifyFomula(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '+') {
                // (...) + (...)
                if (list.get(i - 1) == ')' && list.get(i + 1) == '(') {
                    list.remove(i - 1); list.remove(i);
                    for (int j = i - 1; j >= 0; j--) {
                        if (list.get(j) == '(') {
                            list.remove(j); break;
                        }
                    }
                    for (int k = i + 1; k < list.size(); k++) {
                        if (list.get(k) == ')') {
                            list.remove(k); break;
                        }
                    }
                    i--;
                }
                else if (list.get(i - 1) == ')') {
                    list.remove(i - 1);
                    for (int j = i - 1; j >= 0; j--) {
                        if (list.get(j) == '(') {
                            list.remove(j); break;
                        }
                    }
                    i--;
                }
                else if (list.get(i + 1) == '(') {
                    list.remove(i + 1);
                    for (int k = i + 1; k < list.size(); k++) {
                        if (list.get(k) == ')') {
                            list.remove(k); break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void getFomula(List<Character> list) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> nu = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= '0' && list.get(i) <= '9') {
                int ans = 0, j;
                for (j = i; j < list.size() && list.get(j) >= '0' && list.get(j) <= '9'; j++) {
                    ans *= 10; ans += list.get(j) - '0';
                }
                nu.push(ans);
                i = j - 1;
            }
            else {
                op.push(list.get(i));
            }
        }
        System.out.println(op);
        System.out.println(nu);
    }
}