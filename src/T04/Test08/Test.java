package src.T04.Test08;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        GetAllDocs gd = new GetAllDocs();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径: ");
        String fileDir = scanner.next();
        scanner.close();
        gd.printAllDocs(fileDir);
    }
}