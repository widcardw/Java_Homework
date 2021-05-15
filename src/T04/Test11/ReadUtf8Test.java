package src.T04.Test11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadUtf8Test {
    public static void main(String[] args) {
        File file = new File("./src/T04/Test11/char.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);
            int ch = br.read();
            while (ch != -1) {
                System.out.print((char) ch);
                ch = br.read();
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}