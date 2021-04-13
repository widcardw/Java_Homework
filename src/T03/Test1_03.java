package src.T03;

public class Test1_03 {
    // 创建多个对象时会抛出异常
    public static void main(String[] args) {
        BlueToothApater b = BlueToothApater.getObj();
        b.scan();
        b.connect();
    }
}

// 在上课之前写的
// class BlueToothApater {
//     private static boolean created;

//     public BlueToothApater() throws Exception {
//         if (BlueToothApater.created == true) {
//             throw new Exception("Object has been constructed");
//         }
//         BlueToothApater.created = true;
//     }

//     public void finalize() {
//         BlueToothApater.created = false;
//     }
// }