package src.T03;

import java.util.Scanner;

public class Test2_14 {
    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.nextLine();
        }
        scanner.close();
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\n", getDistance(ss[i]));
        }
    }

    public static double getDistance(String src) {
        Vector2D vector2d = new Vector2D();
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            if (ch == 'L') {
                vector2d.turn(LEFT);
            }
            else if (ch == 'R') {
                vector2d.turn(RIGHT);
            }
            else {
                int j; 
                for (j = i; j < src.length() && src.charAt(j) >= '0' && src.charAt(j) <= '9'; j++) ;
                int distance = Integer.parseInt(src.substring(i, j));
                vector2d.shift(distance);
                i = j - 1;
            }
        }

        return vector2d.getNorm();
    }
}

class Vector2D {
    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int RIGHT = 3;
    private double _x;
    private double _y;
    private int _direction;
    // 0:UP, 1:LEFT, 2: DOWN, 3:RIGHT

    public Vector2D(double x, double y, int direction) {
        this._x = x; this._y = y; this._direction = direction;
    }

    public Vector2D() {
        this._x = this._y = 0; this._direction = UP;
    }

    public void shift(int distance) {
        switch (this._direction) {
            case UP: this._y += distance; break;
            case LEFT: this._x -= distance; break;
            case DOWN: this._y -= distance; break;
            case RIGHT: this._x += distance; break;
        }
    }

    public void turn(int direction) {
        if (direction == LEFT) {
            this._direction = (this._direction + 1) % 4;
        }
        else if (direction == RIGHT) {
            this._direction = (this._direction - 1) % 4;
        }
    }

    public double getNorm() {
        return Math.sqrt(this._x * this._x + this._y * this._y);
    }
}