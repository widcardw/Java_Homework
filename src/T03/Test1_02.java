package src.T03;

public class Test1_02 {
    public static void main(String[] args) {
        Payment pcash = new PayByCash();
        Payment pcred = new PayByCreditCard();
        Payment pvouc = new PayByVouchers();
        Payment pwech = new PayByWeChat();
        Payment palip = new PayByAlipay();
        pcash.pay();
        pcred.pay();
        pvouc.pay();
        pwech.pay();
        palip.pay();
    }
}

interface Payment {
    void pay();
}
class PayByCash implements Payment {
    @Override
    public void pay() {
        System.out.println("现金支付");
    }
}
class PayByCreditCard implements Payment {
    @Override
    public void pay() {
        System.out.println("信用卡支付");
    }
}
class PayByVouchers implements Payment {
    @Override
    public void pay() {
        System.out.println("代金券支付");
    }
}
class PayByWeChat implements Payment {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
class PayByAlipay implements Payment {
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}