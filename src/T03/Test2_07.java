package src.T03;

import java.util.Scanner;

public class Test2_07 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");
        Scanner input = new Scanner(System.in);
        String src = input.next();
        input.close();
        int cyc = getShortestCycle(src);
        System.out.println("字符串：" + src + "的最小周期为：" + cyc);
    }

    // 总觉得好像有点小问题。。。
    public static int getShortestCycle(String src) {
        int[] arr = new int[src.length()];
        getNextArray(arr, src);
        for (int i : arr) {
            System.out.print(" " + i);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                max = i;
            }
        } 
        return max;
    }

    public static void getNextArray(int[] arr, String src) {
        int i = 0, j = -1;
        arr[0] = -1;
        while (i < src.length() - 1) {
            if (j == -1 || src.charAt(i) == src.charAt(j)) {
                i++; j++; arr[i] = j;
            }
            else {
                j = arr[j];
            }
        }
    }
}