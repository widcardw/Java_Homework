package src.T03;

import java.util.Scanner;

public class Test3_02 {
    public static final int A = 0;
    public static final int C = 1;
    public static final int G = 2;
    public static final int T = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String[] src = new String[m];
        int n = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            src[i] = scanner.next();
            assert(src[i].length() == n);
        }
        scanner.close();
        String result = getBestDNA(src);
        System.out.println("最优解为 " + result);
    }

    public static void countApperaTimes(char ch, int[] marks) {
        switch(ch) {
            case 'A': marks[A]++; break;
            case 'C': marks[C]++; break;
            case 'G': marks[G]++; break;
            case 'T': marks[T]++; break;
        }
    }

    public static char getMaxChar(int[] marks) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (marks[i] > marks[max]) {
                max = i;
            }
        }
        switch(max) {
            case 0: return 'A';
            case 1: return 'C';
            case 2: return 'G';
        }
        return 'T';
    }

    public static String getBestDNA(String[] src) {
        String result = "";

        for (int i = 0; i < src[0].length(); i++) {
            int[] marks = new int[4];
            for (int j = 0; j < src.length; j++) {
                countApperaTimes(src[j].charAt(i), marks);
            }
            result += getMaxChar(marks);
        }

        return result;
    }
}