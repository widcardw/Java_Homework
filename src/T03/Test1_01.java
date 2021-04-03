package src.T03;

// 复数运算
public class Test1_01 {
    public static void main(String[] args) {
        Complex c1 = new Complex(1.5, 2.5);
        Complex c2 = new Complex(4.75, -9.9);
        System.out.println("c1=" + c1.toString());
        System.out.println("c2=" + c2.toString());
        Complex c3 = c1.Add(c2);
        Complex c4 = c1.Sub(c2);
        Complex c5 = c1.Mul(c2);
        System.out.println("c1+c2=" + c3.toString());
        System.out.println("c1-c2=" + c4.toString());
        System.out.println("c1*c2=" + c5.toString());
    }
}

class Complex {
    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re; this.im = im;
    }

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

    public void set(double re, double im) {
        this.re = re; this.im = im;
    }

    public double Re() {
        return this.re;
    }

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

// 外部运算类, 可以创建对象后对复数进行运算
class ComplexOperator {
    public Complex Add(Complex a, Complex b) {
        return new Complex(a.Re() + b.Re(), a.Im() + b.Im());
    }

    public Complex Sub(Complex a, Complex b) {
        return new Complex(a.Re() - b.Re(), a.Im() - b.Im());
    }

    public Complex Mul(Complex a, Complex b) {
        double re = a.Re() * b.Re() - a.Im() * b.Im();
        double im = a.Im() * b.Re() + a.Re() * b.Im();
        return new Complex(re, im);
    }
}