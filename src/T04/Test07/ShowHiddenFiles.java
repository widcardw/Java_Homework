package src.T04.Test07                                                      ;

import java.io.File                                                         ;

public class ShowHiddenFiles                                                {
    
    public void printHiddenFiles(String fileDir)                            {
        File dir = new File(fileDir)                                        ;
        printHiddenFiles(dir, 0)                                            ;}

    private void printHiddenFiles(File dir, int blk)                        {
        if (dir.exists())                                                   {
            if (dir.isDirectory())                                          {
                File[] chilFiles = dir.listFiles()                          ;
                for (int i = 0; i < blk; i++) System.out.print("    ")      ;
                System.out.println(dir.getName())                           ;
                for (File file : chilFiles)                                 {
                    printHiddenFiles(file, blk + 1)                         ;}}
            else                                                            {
                if (dir.isHidden())                                         {
                    for (int i = 0; i < blk; i++) System.out.print("    ")  ;
                    System.out.println(dir.getName())                       ;}}}
        else                                                                {
            System.out.println("File or directory does not exist!")         ;}}}
