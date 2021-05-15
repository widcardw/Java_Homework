package src.T04.Test05;

import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] info = new int[3];
        FileCount fileCount = new FileCount();
        System.out.print("请输入一个文件夹: ");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.next();
        scanner.close();
        File file = new File(dir);
        fileCount.getFileCountAndSize(file, info);
        System.out.println("文件夹" + dir + "下的子文件夹总数: " + info[0]);
        System.out.println("文件总数: " + info[1]);
        System.out.println("文件的总空间: " + info[2] + "字节");
    }
}