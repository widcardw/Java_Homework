package src.T02;

import java.util.Scanner;


// 在数组中寻找一个数值，若找到，则返回该数在数组中的下标。若找不到，则返回-1
public class Test17 {
    public static void main(String[] args) {
        int b[] = {
            1, 2, 3, 5, 4, 
            10, 32767, 88, 0, 214,
            -1, 9, 11, 0x12345678, 89,
            76, 20, 54, 78, 90
        };
        System.out.println("请输入要找的数值：");

        Scanner input = new Scanner(System.in);
        int val = input.nextInt();
        input.close();

        System.out.println("数组内容是：");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
            if ((i + 1) % 5 ==0) {
                System.out.println("");
            }
        }
        int index = findValueInArray(b, val);
        if (index >= 0) {
            System.out.println("该数值在数组b中的下标是：" + findValueInArray(b, val));
        }
        else {
            System.out.println("在数组中找不到该数值");
        }
    }
    public static int findValueInArray(int a[], int val) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) {
                index = i; 
                break;
            }
        }
        return index;
    }
}