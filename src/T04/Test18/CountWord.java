package src.T04.Test18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountWord {
    public static void main(String[] args) {
        File file = new File("./src/T04/Test18/data.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        File file2 = new File("./src/T04/Test18/result.txt");
        FileOutputStream fos = null;

        // LinkedHashMap会按照加入的次序来排序
        Map<Character, Integer> map = new LinkedHashMap<>();

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            int ch = 0;
            while ((ch = br.read()) != -1) {
                putOneChar(map, ch);
            }

            fos = new FileOutputStream(file2);

            // 从map的入口获取键值对
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                fos.write(String.format("(%c,%d)", entry.getKey(), entry.getValue()).getBytes());
            }

            fos.close(); br.close(); isr.close(); fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void putOneChar(Map<Character, Integer> map, int ch) {
        if (!map.containsKey((char) ch)) {
            map.put((char) ch, 1);
        }
        else {
            map.put((char) ch, map.get((char) ch) + 1);
        }
    }
}