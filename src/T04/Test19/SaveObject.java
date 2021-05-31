package src.T04.Test19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;

public class SaveObject {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./src/T04/Test19/complex.ser");
            oos = new ObjectOutputStream(fos);
            Complex c1 = new Complex(4, 3);
            oos.writeObject(c1);
            oos.close(); fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("./src/T04/Test19/complex.ser");
            ois = new ObjectInputStream(fis);
            // readObject读取一个对象
            Complex c2 = (Complex) ois.readObject();
            System.out.println(c2.toString());
            ois.close(); fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}