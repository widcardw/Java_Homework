package src.T04.Test20;

import java.io.Serializable;

public class BiTree implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private BiNode root;
    
    public BiTree() {
        super();
        this.root = null;
    }

    private void PreOrder(BiNode p) {
        if (p == null) {
            return;
        }
        System.out.println(p.getValue());
        PreOrder(p.getLchild());
        PreOrder(p.getRchild());
    }
    
    public void PreOrder() {
        PreOrder(this.root);
    }

    private void InOrder(BiNode p) {
        if (p == null) {
            return;
        }
        InOrder(p.getLchild());
        System.out.println(p.getValue());
        InOrder(p.getRchild());
    }

    public void InOrder() {
        InOrder(this.root);
    }

    private void PostOrder(BiNode p) {
        if (p == null) {
            return;
        }
        PostOrder(p.getLchild());
        PostOrder(p.getRchild());
        System.out.println(p.getValue());
    }

    public void PostOrder() {
        PostOrder(this.root);
    }

    private BiNode createByPre(String[] arr, int i) {
        try {
            int e = Integer.parseInt(arr[i]);
            ++i;
            BiNode p = new BiNode(e);
            p.setLchild(createByPre(arr, i));
            p.setRchild(createByPre(arr, i));
            return p;
        }
        catch (Exception e) {
            return null;
        }
    }

    private BiNode createByPreMid(int[] pre, int[] mid, int ipre, int imid, int n) {
        if (n == 0) 
            return null;
        int i;
        BiNode p = new BiNode(pre[ipre]);
        for (i = 0; i < n; i++) 
            if (pre[ipre] == mid[imid + i])
                break;
        p.setLchild(createByPreMid(pre, mid, ipre + 1, imid, i));
        p.setRchild(createByPreMid(pre, mid, ipre + i + 1, imid + i + 1, n - i - 1));
        return p;
    }

    public BiTree(int[] pre, int[] mid) {
        super();
        this.root = createByPreMid(pre, mid, 0, 0, pre.length);
    }

    public BiTree(String[] pre) {
        super();
        int i = 0;
        this.root = createByPre(pre, i);
    }

    private String serialize(BiNode p, String s) {
        if (p != null) {
            s += String.valueOf(p.getValue()) + ",";
            s = serialize(p.getLchild(), s);
            s = serialize(p.getRchild(), s);
            return s;
        }
        else {
            return s + "#,";
        }
    }

    public String serialize() {
        return serialize(this.root, "");
    }

    private BiNode deserialize(String ss, int i) {
        String[] arr = ss.split(",");
        return createByPre(arr, 0);
    }

    public void deserialize(String ss) {
        this.root = deserialize(ss, 0);
    }
}
