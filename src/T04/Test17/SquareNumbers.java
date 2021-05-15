package src.T04.Test17;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SquareNumbers {
    public static void main(String[] args) {
        File file = new File("./src/T04/Test17/data.txt");
        FileOutputStream fos = null;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        getPairs(list);

        try {
            fos = new FileOutputStream(file);
            for (Pair<Integer,Integer> pair : list) {
                fos.write(String.format("%d\t%d\n", pair.getKey(), pair.getValue()).getBytes());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPairs(List<Pair<Integer, Integer>> list) {
        for (int i = 100; i < 1000; i++) {
            if (squareNumberContainsSelf(i)) {
                Pair<Integer, Integer> p = new Pair<Integer,Integer>(i, i * i);
                list.add(p);
            }
        }
    }

    public static boolean squareNumberContainsSelf(int x) {
        String square_x = String.valueOf(x * x);
        String x_str = String.valueOf(x);
        return square_x.contains(x_str);
    }
}