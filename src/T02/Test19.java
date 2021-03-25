package src.T02;

import java.util.Scanner;


// 按步长k输出数组中元素。已输出的元素要跳过去，不要重复输出
// 已知数组a:{1,2,3,4,5,6,7,8,9,10,11}，步长k=3，则输出的序列为：3  6  9  1  5  10  4 11  8  2  7
public class Test19 {
    public static void main(String[] args) {
        int arr_length = 11;
        System.out.println("请输入" + arr_length + "个整数");
        Scanner input = new Scanner(System.in);
        int[] b = new int[arr_length];
        for (int i = 0; i < arr_length; i++) {
            b[i] = input.nextInt();
        }
        System.out.print("请输入步长k：");
        int k = input.nextInt();
        input.close();
        
        System.out.println("数组内容是：");
        printArray(b);
        System.out.println("\n按步长输出的序列是：");
        printArrayByStep(b, k);
    }
    public static void printArray(int a[]) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
    public static void printArrayByStep(int a[], int k) {
        boolean[] visited = new boolean[a.length];
        int i = 0;
        for (i = 0; i < a.length; i++) {
            visited[i] = false;
        }
        i = k - 1;
        int count = 0;
        while (count < a.length) {
            if (!visited[i]) {
                System.out.print(a[i] + " ");
                visited[i] = true; 
                count++; i++;
                if (count >= a.length) { return; }
                int j = 0, l = 0;
                while (j < k) {
                    if (visited[(i + l) % a.length] == false) {
                        j++;
                    }
                    l++;
                }
                i = (i + l - 1) % a.length;
            }
            else {
                i = (i + 1) % a.length;
            }
        }
    }
}