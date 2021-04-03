package src.T03;

public class Test1_03 {
    // 创建多个对象时会抛出异常
    public static void main(String[] args) throws Exception {
        BlueToothApater b1 = new BlueToothApater();
        // b1.finalize();
        BlueToothApater b2 = new BlueToothApater();
        System.out.println("Success!");
    }
}

class BlueToothApater {
    // 静态变量控制是否已经创建对象
    private static boolean created;

    public BlueToothApater() throws Exception {
        if (BlueToothApater.created == true) {
            throw new Exception("Object has been constructed");
        }
        BlueToothApater.created = true;
    }

    public void finalize() {
        BlueToothApater.created = false;
    }
}