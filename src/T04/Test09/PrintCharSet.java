package src.T04.Test09;

import java.nio.charset.Charset;

public class PrintCharSet {
    public static void main(String[] args) {
        // 有点懵?
        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("sun.jnu.encoding"));
    }
}