package src.T04.Test20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveTree {
    public static void main(String[] args) {
        int[] pre = { 3, 2, 9, 1, 8, 6, 7, 5, 10, 4 };
        int[] mid = { 1, 9, 2, 6, 8, 3, 5, 10, 7, 4 };

        // CBIAHFGEJD
        // AIBFHCEJGD

        BiTree biTree = new BiTree(pre, mid);
        biTree.PreOrder();
        // System.out.println(biTree.serialize());

        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("./src/T04/Test20/tree.ser");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(biTree);
            oos.close();
            fos.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("./src/T04/Test20/tree.ser");
            ois = new ObjectInputStream(fis);
            BiTree biTree2 = (BiTree) ois.readObject();
            biTree2.PreOrder();
            ois.close(); fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}