package src.T04.Test16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TransposeMatrix2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/T04/Test16/data.txt"));
            List<List<Integer>> list = readMatrixFromFile(br);
            PrintWriter pw = new PrintWriter(new File("./src/T04/Test16/data90.txt"));
            for (int i = 0; i < list.get(0).size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    pw.print(list.get(j).get(i) + " ");
                }
                pw.println();
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<List<Integer>> readMatrixFromFile(BufferedReader br) {
        String line = null;
        List<List<Integer>> list = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\\s+");
                List<Integer> li = new ArrayList<>();
                for (String e : ss) {
                    if (!e.isEmpty()) {
                        li.add(Integer.parseInt(e));
                    }
                }
                list.add(li);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}