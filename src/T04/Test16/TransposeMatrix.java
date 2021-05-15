package src.T04.Test16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TransposeMatrix {
    public static void main(String[] args) {
        File file1 = new File("./src/T04/Test16/data.txt");
        File file2 = new File("./src/T04/Test16/data90.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file1);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            fos = new FileOutputStream(file2);

            List<List<Integer>> list = new ArrayList<>();
            readArrayFromFile(list, br);
            int row = list.size(), col = list.get(0).size();
            int[][] tarr = new int[col][row];
            transposeMatrix(list, tarr);

            for (int[] is : tarr) {
                for (int is2 : is) {
                    fos.write(String.format("%d\t", is2).getBytes());
                }
                fos.write("\n".getBytes());
            }

            fos.close(); br.close(); isr.close(); fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readArrayFromFile(List<List<Integer>> list, BufferedReader br) {
        try {
            String str = null;
            while ((str = br.readLine()) != null) {
                String[] brr = str.split("\\s");
                List<Integer> l1 = new ArrayList<>();
                for (String string : brr) {
                    if (!string.isEmpty()) {
                        l1.add(Integer.parseInt(string));
                    }
                }
                list.add(l1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void transposeMatrix(List<List<Integer>> list, int[][] tarr) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                tarr[j][i] = list.get(i).get(j);
            }
        }
    }
}