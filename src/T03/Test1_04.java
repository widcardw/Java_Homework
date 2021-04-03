package src.T03;

import java.util.Scanner;

public class Test1_04 {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入数组元素个数: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.printf("请输入%d个数: ", n);
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print("请输入排序的方式\n1.冒泡\n2.选择\n3.插入\n选择: ");
        int choice = input.nextInt();
        input.close();
        SortMethod m;
        switch (choice) {
            case 1:
                m = new BubbleSort();
                m.sort(arr);
                break;
            case 2:
                m = new SelectionSort();
                m.sort(arr);
                break;
            case 3:
                m = new InsertionSort();
                m.sort(arr);
                break;
            default: 
                break;
        }
        System.out.println("排序后数组: ");
        for (int i : arr) {
            System.out.print(" " + i);
        }
    }
}

interface SortMethod {
    void sort(int[] arr);
    
    public default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class BubbleSort implements SortMethod {
    @Override
    public void sort(int[] arr) {
        boolean exchange = true;
        int i = 1;
        while (exchange) {
            exchange = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    exchange = true;
                }
            }
            i++;
        }
    }
}

class SelectionSort implements SortMethod {
    @Override
    public void sort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }
}

class InsertionSort implements SortMethod {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j;
            for (j = i - 1; j >=0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }
}