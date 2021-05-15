package src.T04.Test13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class GetNumbers {
    public static void main(String[] args) {
        File file1 = new File("./src/T04/Test13/t1.txt");
        File file2 = new File("./src/T04/Test13/t2.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file1);
            isr = new InputStreamReader(fis, "gbk");
            br = new BufferedReader(isr);

            fos = new FileOutputStream(file2);

            String str = null;
            while ((str = br.readLine()) != null) {
                String[] numbeStrings = str.split("\\D+");
                for (String string : numbeStrings) {
                    if (string.isEmpty()) continue;
                    string += "\t";
                    fos.write(string.getBytes());
                }
            }

            fos.close();
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}