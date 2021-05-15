package src.T04.Test19;

import java.io.Serializable;

public class Complex implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 998244353L;
    private double re;
    private double im;

    // constructor
    public Complex(double re, double im) {
        this.re = re; this.im = im;
    }

    // toString, format: x+yi
    public String toString() {
        String result = "";
        if (this.re != 0) {
            result += this.re;
        }
        if (this.im != 0) {
            if (this.re != 0 && this.im > 0) {
                result += "+";
            }
            result += this.im + "i";
        }
        return result;
    }

    // set the value of complex
    public void set(double re, double im) {
        this.re = re; this.im = im;
    }

    // returns the real part of complex
    public double Re() {
        return this.re;
    }

    // returns the imaginary part of complex
    public double Im() {
        return this.im;
    }

    // 内置加法方法, 返回新的对象
    public Complex Add(Complex another) {
        return new Complex(this.re + another.re, this.im + another.im);
    }

    // 内置减法方法, 返回新的对象
    public Complex Sub(Complex another) {
        return new Complex(this.re - another.re, this.im - another.im);
    }

    // 内置乘法方法, 返回新的对象
    public Complex Mul(Complex another) {
        return new Complex(
            this.re * another.re - this.im * another.im, 
            this.re * another.im + this.im * another.re
        );
    }
}