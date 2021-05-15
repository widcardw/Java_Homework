package src.T04.Test06;

import java.io.File;
import java.util.Scanner;

public class MoveDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要移动的文件夹: ");
        String sourcePath = scanner.next();
        System.out.print("请输入目标文件夹");
        String destPath = scanner.next();
        scanner.close();
        MoveDirectory moveDirectory = new MoveDirectory(sourcePath, destPath);
        moveDirectory.moveDir();
    }

    private String sourcePath;
    private String destPath;

    public MoveDirectory(String sourcePath, String destPath) {
        this.sourcePath = sourcePath; this.destPath = destPath;
    }

    public void moveDir() {
        File source = new File(this.sourcePath);
        if (source.exists())
            move(source);
        else {
            System.out.println("Source Directory does not exist!");
            return;
        }
    }

    private void move(File dir) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                File oldFile = new File(files[i].getAbsolutePath());
                File newPath = new File(this.destPath);
                if (!newPath.exists()) {
                    newPath.mkdir();
                }
                File fnew = new File(this.destPath + "/" + oldFile.getName());
                oldFile.renameTo(fnew);
            }
            else {
                move(files[i]);
            }
        }
    }
}