package src.T04.Test17;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SquareNumbers2 {

    public static boolean squareNumberContainsSelf(int x) {
        String x_square = String.valueOf(x * x);
        String x_str = String.valueOf(x);
        return x_square.contains(x_str);
    }

    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter(new File("./src/T04/Test17/data.txt"));
            for (int i = 100; i < 1000; i++) {
                if (squareNumberContainsSelf(i)) {
                    pw.println("" + i + "\t" + (i * i));
                }
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}