package src;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // System.out.println("Hello, Java!");
        Solution solution = new Solution();
        solution.kangteshu();
    }
    
}
class Solution {
    // 打印九九乘法表
    public void t1_1MultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println("");
        }
    }
    // 输入n, t, ch, 打印树冠高n, 树干高t的松树
    public void t1_2PrintPineTree() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        char ch = input.next().charAt(0);
        input.close();
        int i = 0, j = 0, k = 0;
        for (i = 0; i < n; i++) {
            for (j = 1; j < n - i; j++) {
                System.out.printf(" ");
            }
            for (k = 0; k < 2 * i + 1; k++) {
                System.out.printf("%c", ch);
            }
            System.out.println("");
        }
        for (i = 0; i < t; i++) {
            for (j = 0; j < n - 1; j++) {
                System.out.printf(" ");
            }
            System.out.println(ch);
        }
    }
    // 合并指定的四个byte, 保存到int中
    public void t1_3ConcateFourBytes() {
        byte b1 = (byte) 0xaa, b2 = (byte) 0xbb, b3 = (byte) 0xcc, b4 = (byte) 0xdd;
        // Scanner input = new Scanner(System.in);
        // byte b1 = input.nextByte();
        // byte b2 = input.nextByte();
        // byte b3 = input.nextByte();
        // byte b4 = input.nextByte();
        // input.close();
        int i = ((b4 << 24) | 0x00ffffff) &
                ((b3 << 16) | 0xff00ffff) &
                ((b2 << 8) | 0xffff00ff) &
                (b1 | 0xffffff00);  // 类似于掩码
        System.out.printf("%d\n", i);
    }
    // 计算从1到n的所有奇数的和
    public void t2_1CalculateSumOfOddNumbers() {
        System.out.print("请输入一个正整数: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        if (n <= 0) {
            System.err.println("Input error!");
            return;
        }
        int sum = 0;
        int i = 1;
        System.out.printf("%d", i);
        while (true) {
            sum += i;
            i += 2;
            if (i > n) 
                break;
            System.out.printf("+%d", i);
        }
        System.out.println("=" + sum);
    }
    // 计算从m到n(包含两头)的数之和
    public void t2_2CalculateNumbersInRange() {
        System.out.print("请输入两个正整数: ");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int sum = 0, i = m;
        input.close();
        if (m > n) {
            System.err.println("Input error!");
            return;
        }
        System.out.printf("%d", i);
        while (true) {
            sum += i;
            i++;
            if (i > n) 
                break;
            System.out.printf("+%d", i);
        }
        System.out.println("=" + sum);
    }
    // i+(i+k)+(i+2*k)+(i+3*k)…*j之和
    public void t2_3CalculateFomula() {
        System.out.print("请输入三个正整数: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        int k = input.nextInt();
        int j = input.nextInt();
        input.close();
        if (j < i) {
            System.err.println("Input error!");
            return;
        }
        int l = i, sum = 0; // l = times * k
        System.out.printf("%d", l);
        while (true) {
            sum += l;
            l += k;
            if (l > j) 
                break;
            System.out.printf("+%d", l);
        }
        System.out.println("=" + sum);
    }
    // 输入i~j之间所有的质数，每行k个
    public void t2_4GetPrimeNumbersInRange() {
        System.out.print("请输入三个正整数值: ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        int j = input.nextInt();
        int k = input.nextInt();
        input.close();
        for (int m = i, n = 0; m <= j; m++) {
            if (isNotPrime(m) == false) {
                System.out.printf("%d ", m);
                n++; n %= k;
                if (n == 0){
                    System.out.println("");
                }
            }
        }
    }
    public boolean isNotPrime(int x) {
        boolean flag = false;
        int sqrt_x = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrt_x; i++) {
            if (x % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    // 输出前n个质数，每行k个。
    public void t2_5GetPrimes() {
        System.out.print("请输入两个正整数值: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        input.close();
        int i = 2, j = 0;
        while (j < n) {
            if (isNotPrime(i) == false) {
                System.out.printf("%d ", i);
                j++;
                if (j % k == 0) {
                    System.out.println("");
                }
            }
            i++;
        }
    }
    // 1-1/2+1/3-1/4+1/5-1/6+…..1/n=?
    public void t2_6CalculateFractions() {
        System.out.print("请输入三个正整数值: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        double sum = 0;
        for (double i = 1; i <= n; i++) {
            sum += 1 / i * (translateBooleanToSign(i % 2 == 1));
        }
        System.out.println("和=" + sum);
    }
    public int translateBooleanToSign(boolean f) {
        if (f) return 1;
        return -1;
    }
    // 求最大公约数
    public int gcdByMinus(int a, int b) {
        while(a != b) {
            if (a > b) {
                a = a - b;
            }
            else if (a < b) {
                b = b - a;
            }
        }
        return a;
    }
    public int gcdByMod(int a, int b) {
        if (a < b) {
            int temp = a; a = b; b = temp;
        }
        while (b != 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }
    public void t3_1gcd() {
        System.out.print("请输入两个正整数: ");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        input.close();
        int gcd_1 = gcdByMinus(m, n);
        int gcd_2 = gcdByMod(m, n);
        System.out.println(m + "和" + n + "的最大公约数是: " + gcd_1);
        System.out.println(m + "和" + n + "的最大公约数是: " + gcd_2);
    }
    // 输出所有的形如aabb的四位平方数
    public void t3_2GetAABBSquareNumbers() {
        for (int i = 32; i < 100; i++) {
            int x = i * i;
            int ah = x / 1000, al = (x / 100) % 10;
            int bh = (x / 10) % 10, bl = x % 10;
            if (ah == al && bh == bl) {
                System.out.println(x);
            }
        }
    }
    // 求出：s=1!+2!+…+n!这个很大的和的末6位
    public void t3_3GetLowDecimalsOfSumFactorial() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        if (n < 1) {
            System.out.println("Input error!");
            return;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getLowDecimalsOfFactorial(i);
            sum %= 1000000;
        }
        System.out.println(sum);
    }
    public int getLowDecimalsOfFactorial(int n) {
        int pi = 1;
        for (int i = 2; i <= n; i++) {
            pi *= i;
            pi %= 1000000;
        }
        return pi;
    }
    // 韩信点兵
    public void t3_4GetLengthOfQueue() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        input.close();
        if (a >= 3 || b >= 5 || c >= 7) {
            System.err.println("Input error!");
            return;
        }
        int sum = (70 * a + 21 * b + 15 * c) % 105;
        if (sum < 10 || sum >= 100) {
            System.out.println("无解");
            return;
        }
        System.out.println("总人数（最小值）= " + sum);
    }
    // abc:def:ghi=1:2:3
    public void t3_5() {
        int i, j;
        int a, b, c;
        boolean x[] = new boolean[10];
        for (i = 123; i <= 329; i++) {
            boolean flag = true;
            for (j = 0; j < 10; j++) { 
                x[j] = false;  // 给x数组置初始值
            }
            a = i; b = i * 2; c = i * 3;
            changeFlagsOfNumbers(x, a, b, c);  // 验证有哪些数字用到了, 哪些没用到
            for (j = 1; j < 10; j++) {
                if (x[j] == false) {
                    flag = false;  // 如果没用到1~9的某个数字, 那么就不满足条件
                    break;
                }
            }
            if (flag) {
                System.out.println(a + "," + b + "," + c);
            }
        }
    }
    public void changeFlagsOfNumbers(boolean flags[], int a, int b, int c) {
        int a1 = a / 100, a2 = (a / 10) % 10, a3 = a % 10;
        int b1 = b / 100, b2 = (b / 10) % 10, b3 = b % 10;
        int c1 = c / 100, c2 = (c / 10) % 10, c3 = c % 10;
        flags[a1] = flags[a2] = flags[a3] = true;
        flags[b1] = flags[b2] = flags[b3] = true;
        flags[c1] = flags[c2] = flags[c3] = true;
    }
    // 康特数?
    public void t3_6() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        int level = (int) Math.sqrt(2 * n);
        int delta = 2 * n - level * level;
        if (delta > level) level++;  // level为n所在的层数
        int levelStart = 1;  // 第level层第一个数的索引
        for (int i = 0; i < level; i++) 
            levelStart += i;
        int x = level, y = 1;  // 用于输出的两个整数
        for (int i = levelStart; i < n; i++) {
            x--; y++;
        }
        if (level % 2 == 0) {
            System.out.println(y + "/" + x);
        }
        else {
            System.out.println(x + "/" + y);
        }
    }
    // 1/a+1/b+1/c+1/d=1
    public void t3_7() {
        for (int d = 20; d > 0; d--) {
            for (int c = d - 1; c > 0; c--) {
                for (int b = c - 1; b > 0; b--) {
                    for (int a = b - 1; a >0; a--) {
                        if (Math.abs(1.0 / a + 1.0 / b + 1.0 / c + 1.0 / d - 1) < 1e-6) {
                            System.out.println(d + "," + c + "," + b + "," + a + "," + 0);
                        }
                    }
                }
            }
        }
    }
    public void kangteshu() {
        int[][] array = new int[1000][1000];
        int i = 0, j = 0, k = 1;
        boolean direction = false;
        while(i <=30 && j <= 30) {
            array[i][j] = k;
            k++;
            if (j <= 0) { j++; direction = !direction; array[i][j] = k; k++; }
            else if (i <= 0) { i++; direction = !direction; array[i][j] = k; k++; }
            else {
                if (direction) { j--; i++; }
                else { j++; i--; }
            }
        }
        for (i = 0; i < 30; i++) {
            for (j = 0; j < 30; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println("");
        }
    }
}