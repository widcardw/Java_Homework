package src.T02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

// 这似乎是一个 Huffman树 问题
// 但是用huffman树做好像麻烦了, 要从底层开始构造, 然后再从顶端开始层次遍历
// 👆好像第二个测试不太对, 错的
public class Test37 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  // 接水人数
        int m = input.nextInt();  // 水龙头个数
        int[] w = new int[n];  // 每个人要接的水
        for (int i = 0; i < n; i++) {
            w[i] = input.nextInt();
        }
        input.close();

        int result = solve(n, m, w);
        
        System.out.println(result);
    }

    public static int solve(int n, int m, int[] w) {
        if (m >= n) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (w[i] > max) {
                    max = w[i];
                }
            }
            return max;
        }
        HuffmanTree tree = new HuffmanTree(w);
        Queue<HuffNode> queue = new LinkedList<HuffNode>();

        int result = tree.getTopM(queue, m);
        return result;
    }
}

class HuffNode {
    public int value;
    public int parent, lchild, rchild;
    public HuffNode(int value, int parent, int lchild, int rchild) {
        this.value = value;
        this.parent = parent;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}

class HuffmanTree {
    private Vector<HuffNode> hufftree;
    private int n;

    // 构造函数
    public HuffmanTree(int[] leafs) {
        n = leafs.length;
        int i;
        hufftree = new Vector<HuffNode>();
        hufftree.setSize(2 * n - 1);
        int least[] = { 0x80000000, 0x80000000 };
        for (i = 0; i < n; i++) {
            hufftree.set(i, new HuffNode(leafs[i], -1, -1, -1));
        }
        for (i = n; i < 2 * n - 1; i++) {
            selectSmall(least, i);
            hufftree.elementAt(least[0]).parent = i;
            hufftree.elementAt(least[1]).parent = i;
            hufftree.set(i, new HuffNode(
                hufftree.elementAt(least[0]).value + hufftree.elementAt(least[1]).value, 
                -1, least[0], least[1]
            ));
        }
    }

    public void selectSmall(int[] least, int i) {
        int k;
        least[0] = least[1] = 0;
        // 选出值最小的节点索引
        for (k = 0; k < i; k++) {
            // 排除已经被加入树中的节点
            while (hufftree.elementAt(least[0]).parent != -1)
                least[0]++;
            // 同上
            if (hufftree.elementAt(k).parent != -1)
                continue;
            else if (hufftree.elementAt(k).value < hufftree.elementAt(least[0]).value)
                least[0] = k;
        }
        // 选出值第二小的节点索引
        for (k = 0; k < i; k++) {
            // 跳过与最小重合的和已经加入树中的
            while (hufftree.elementAt(least[1]).parent != -1 || least[1] == least[0])
                least[1]++;
            if (hufftree.elementAt(k).parent != -1 || k == least[0])
                continue;
            if (hufftree.elementAt(k).value < hufftree.elementAt(least[1]).value)
                least[1] = k;
        }
    }

    public int findGreatest() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (hufftree.elementAt(i).value > max) {
                max = hufftree.elementAt(i).value;
            }
        }
        return max;
    }

    public int getTopM(Queue<HuffNode> queue, int m) {
        // if (m >= n) {
        //     return findGreatest();
        // }  // 优化已经在构造之前做好了
        // 此部分用于防止 m >= n 时 queue 发出空集合的报错
        int i = 2 * n - 2;
        queue.add(hufftree.elementAt(i));
        HuffNode node;
        while (queue.size() < m) {
            node = queue.remove();
            if (node.rchild != -1)
                queue.add(hufftree.elementAt(node.rchild));
            if (node.lchild != -1)
                queue.add(hufftree.elementAt(node.lchild));
        }
        return queue.peek().value;
    }
}