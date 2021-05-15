package src.T04.Test20;

import java.io.Serializable;

public class BiNode implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Object value;
    private BiNode lchild;
    private BiNode rchild;
    
    public BiNode(Object obj) {
        super();
        this.value = obj;
        this.lchild = this.rchild = null;
    }

    public BiNode() {
        this(null);
    }

    public Object getValue() {
        return this.value;
    }

    public BiNode getLchild() {
        return this.lchild;
    }

    public BiNode getRchild() {
        return this.rchild;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public void setLchild(BiNode lchild) {
        this.lchild = lchild;
    }

    public void setRchild(BiNode rchild) {
        this.rchild = rchild;
    }
}