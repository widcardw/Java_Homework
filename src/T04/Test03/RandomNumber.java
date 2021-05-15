package src.T04.Test03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) throws IOException {
        outputRandomNumber("./test.dat");
        int[] arr = new int[100];
        readData("./test.dat", arr);
        int sum = getSum(arr);
        int avg = sum / arr.length;
        System.out.println("总和=" + sum + ", 平均=" + avg);
    }

    public static void outputRandomNumber(String destFile) throws IOException {
        Random random = new Random();
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt() % 500;
            String ss = x + "\n";
            fileOutputStream.write(ss.getBytes());
        }
        fileOutputStream.close();
    }

    public static void readData(String sourceFile, int[] arr) throws IOException {
        File fin = new File(sourceFile);
        Scanner scanner = new Scanner(fin);
        for (int i = 0; scanner.hasNext() && i < 100; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static int getAverage(int[] arr) {
        int sum = getSum(arr);
        return sum / arr.length;
    }
}