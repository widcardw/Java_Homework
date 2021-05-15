package src.T04.Test07;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileDir = scanner.next();
        scanner.close();
        ShowHiddenFiles sf = new ShowHiddenFiles();
        sf.printHiddenFiles(fileDir);
    }
}