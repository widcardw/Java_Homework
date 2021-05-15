package src.T04.Test05;

import java.io.File;

public class FileCount {
    
    public void getFileCountAndSize(File file, int[] info) {
        info[0] = -1; info[1] = info[2] = 0;
        this.getFileInfo(file, info);
    }
    // info[0] == 文件夹数, info[0] == 文件数, info[2] == 文件总大小
    private void getFileInfo(File file, int[] info) {
        if (file.exists()) {
            if (file.isDirectory()) {
                info[0]++;
                File[] children = file.listFiles();
                for (File file2 : children) {
                    getFileInfo(file2, info);
                }
            }
            else {
                info[1]++;
                info[2] += file.length();
            }
        }
        else {
            System.out.println("File or directory does not exist!");
        }
    }
}