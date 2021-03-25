package src.T02;

import java.util.Scanner;


// 对多个字符串按字典次序进行从小到大排序
public class Test25 {
    public static void main(String[] args) {
        System.out.print("请输入字符串个数: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String[] words = new String[num];
        System.out.println("请输入" + num + "个字符串: ");
        for (int i = 0; i < num; i++) {
            words[i] = input.next();
        }
        input.close();
        System.out.println("排序前: ");
        for (String string : words) {
            System.out.println(string);
        }

        System.out.println("排序后: ");
        sortByDictionary(words);
        for (String string : words) {
            System.out.println(string);
        }
    }
    public static void sortByDictionary(String[] words) {
        quickSortWords(words, 0, words.length - 1);
    }
    public static void insertionSort(String[] words, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            String temp = words[i]; int j;
            for (j = i - 1; j >= 0 && temp.compareTo(words[j]) < 0; j--) {
                words[j + 1] = words[j];
            }
            words[j + 1] = temp;
        }
    }
    public static int Partition(String[] words, int i, int j) {
        String temp = words[i];
        while (i < j) {
            while (i < j && temp.compareTo(words[j]) <= 0) 
                j--;
            if (i < j) {
                words[i] = words[j]; i++;
            }
            while (i < j && temp.compareTo(words[i]) >= 0) 
                i++;
            if (i < j) {
                words[j] = words[i]; j--;
            }
        }
        words[i] = temp;
        return i;
    }
    public static void quickSortWords(String[] words, int i, int j) {
        if (i < j) {
            if (j - i < 5) {
                insertionSort(words, i, j);
            }
            else {
                int pivot = Partition(words, i, j);
                quickSortWords(words, i, pivot - 1);
                quickSortWords(words, pivot + 1, j);
            }
        }
    }
}