package src.T04.Test12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadLinesOfAnsiText {
    public static void main(String[] args) {
        File file = new File("./src/T04/Test12/lines.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "gbk");
            br = new BufferedReader(isr);
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}