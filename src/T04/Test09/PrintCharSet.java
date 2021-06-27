package src.T04.Test09;

import java.io.FileReader;
import java.io.IOException;

public class PrintCharSet {
    public static void main(String[] args) throws IOException {
        // 有点懵?
        // System.out.println(Charset.defaultCharset());
        // System.out.println(System.getProperties());
        // System.out.println(System.getProperty("sun.jnu.encoding"));
        FileReader fr = new FileReader("./src/T04/Test10/text.txt");
        System.out.println(fr.getEncoding());
        fr.close();
    }
}