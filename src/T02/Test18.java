package src.T02;


// 数组的转置
public class Test18 {
    public static void main(String[] args) {
        int b[] = {3, 4, 5, 1, -9, 0, 7};
        System.out.print("数组转置前：");
        for (int i : b) {
            System.out.print(i + " ");
        }
        reverse(b);
        System.out.print("\n数组转置后：");
        for (int i : b) {
            System.out.print(i + " ");
        }
    }
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void reverse(int a[]) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - 1 - i);
        }
    }
}