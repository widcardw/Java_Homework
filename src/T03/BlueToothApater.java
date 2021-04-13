package src.T03;

public class BlueToothApater {
    // 隐藏构造, 外部不可通过 new 方法创建对象
    private BlueToothApater() {
        
    }

    // 通过类方法获取单例对象
    public static BlueToothApater getObj() {
        return obj;
    }

    // 只能创建一个对象
    private static BlueToothApater obj = new BlueToothApater();

    public void scan() {
        System.out.println("扫描中...");
    }

    public void connect() {
        System.out.println("连接中...");
    }
}