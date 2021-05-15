package src.T04.Test08;

import java.io.File;

public class GetAllDocs {

    public void printAllDocs(String fileDir) {
        File dir = new File(fileDir);
        printAllDocs(dir);
    }

    private void printAllDocs(File dir) {
        if (dir.exists()) {
            if (!dir.isDirectory()) {
                String fileName = dir.getName();
                if (fileName.substring(fileName.length() - 4) == ".doc") {
                    System.out.println(fileName);
                }
            }
            else {
                File[] chilFiles = dir.listFiles();
                for (File file : chilFiles) {
                    printAllDocs(file);
                }
            }
        }
    }
}