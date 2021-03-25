package src.T02;

import java.util.Scanner;


// 输入一个整数n表示成绩（在0~100之间）,然后在屏幕上输出表示成绩等级的*
public class Test10 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");

        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        input.close();

        getGradeFromScore(score);
    }
    public static void getGradeFromScore(int score) {
        if (score >= 90 && score <= 100) {
            for (int i = 0; i < 5; i++) {
                System.out.print("*");
            }
        }
        else if (score >= 80 && score <= 89) {
            for (int i = 0; i < 4; i++) {
                System.out.print("*");
            }
        }
        else if (score >= 70 && score <= 79) {
            for (int i = 0; i < 3; i++) {
                System.out.print("*");
            }
        }
        else if (score >= 60 && score <= 69) {
            for (int i = 0; i < 2; i++) {
                System.out.print("*");
            }
        }
        else if (score >= 0 && score < 60) {
            System.out.print("*");
        }
        else {
            System.out.println("Input error!");
        }
    }
}