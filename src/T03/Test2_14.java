package src.T03;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_14 {
    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.nextLine();
        }
        scanner.close();
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\n", getDistance(ss[i]));
        }
    }

    public static HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("L", LEFT);
        map.put("R", RIGHT);
        map.put(null, 0);
        map.put("", 0);
    }

    public static double getDistance(String src) {
        Vector2D vector2d = new Vector2D();
        Pattern p = Pattern.compile("([LR]{0,1})(\\d{0,})");
        Matcher m = p.matcher(src);
        while (m.find()) {
            String dir = m.group(1);
            String dis = m.group(2);
            // if (dir != null && dir.length() > 0) {
                vector2d.turn(map.get(dir));
            // }
            if (dis != null && dis.length() > 0) {
                int d = Integer.parseInt(dis);
                vector2d.shift(d);
            }
        }
        // for (int i = 0; i < src.length(); i++) {
        //     char ch = src.charAt(i);
        //     if (ch == 'L') {
        //         vector2d.turn(LEFT);
        //     }
        //     else if (ch == 'R') {
        //         vector2d.turn(RIGHT);
        //     }
        //     else {
        //         int j; 
        //         for (j = i; j < src.length() && src.charAt(j) >= '0' && src.charAt(j) <= '9'; j++) ;
        //         int distance = Integer.parseInt(src.substring(i, j));
        //         vector2d.shift(distance);
        //         i = j - 1;
        //     }
        // }

        return vector2d.getNorm();
    }
}
