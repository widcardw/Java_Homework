package src.T04.Test15;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class WritePrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt(), s = scanner.nextInt(), t = scanner.nextInt();
        scanner.close();

        FileOutputStream fos = null;
        File file = new File("./src/T04/Test15/primes.txt");
        writePrimes(file, fos, p, s, t);
    }

    public static void writePrimes(File file, FileOutputStream fos, int p, int s, int t) {
        try {
            fos = new FileOutputStream(file);
            
            while (p < s) {
                int count = 0;
                int[] tempArr = new int[t];
                while (count < t && p < s) {
                    if (isPrime(p)) {
                        tempArr[count++] = p;
                    }
                    p++;
                }
                for (int i = 0; i < count; i++) {
                    fos.write(String.format("%d\t", tempArr[i]).getBytes());
                }
                fos.write(String.format("%d\n", getSum(tempArr)).getBytes());
            }

            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSum(int... arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) 
                return false;
        }
        return true;
    }
}