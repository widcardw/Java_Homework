package src.T04.Test10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadText {
    public static void main(String[] args) {
        File file = new File("./src/T04/Test10/text.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "gbk");
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
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}