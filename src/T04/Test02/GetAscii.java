package src.T04.Test02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class GetAscii {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.next();
        scanner.close();
        byte[] bytes = src.getBytes();
        FileOutputStream fileOutputStream = new FileOutputStream("./test.dat");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}