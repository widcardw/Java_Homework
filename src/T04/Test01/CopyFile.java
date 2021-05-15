package src.T04.Test01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入源文件的路径文件名: ");
        String sourceFile = scanner.nextLine();
        System.out.print("请输入目标文件的路径文件名: ");
        String destFile = scanner.nextLine();
        scanner.close();
        copyFile(sourceFile, destFile);
    }

    public static void copyFile(String sourceFile, String destFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        byte[] buf = new byte[0x200000];
        int bufRead = 0;

        while ((bufRead = fileInputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, bufRead);
        }

        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("已成功复制完成");
    }
}