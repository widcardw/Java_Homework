package src.T02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


// 有n根棍子，长度分别是L1,L2,…,Ln。想要从中选出三根棍子，组成周长尽可能长的三角形
public class Test33 {
    public static int N = 10;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        getInput(list);
        int[] result = new int[3];
        boolean flag = false;
        
        for (int i = list.size() - 1; i >= 2; i--) {
            if (list.get(i) < list.get(i - 1) + list.get(i - 2)) {
                result[0] = list.get(i);
                result[1] = list.get(i - 1);
                result[2] = list.get(i - 2);
                flag = true;
                break;
            }
        }
        
        if (flag) {
            System.out.printf("最大周长的三角形连长分别是: %d %d %d\n", result[0], result[1], result[2]);
        }
        else {
            System.out.println("无法组成三角形");
        }
    }
    public static void getInput(List<Integer> list) {
        System.out.printf("请输入%d根棍子的长度：", N);
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            list.add(input.nextInt());
        }
        input.close();
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}