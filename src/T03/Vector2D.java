package src.T03;

public class Vector2D {
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
            this._direction = (this._direction + 3) % 4;
        }
    }

    public double getNorm() {
        return Math.sqrt(this._x * this._x + this._y * this._y);
    }
}