package entity.payment;

import strategy.payment.PayStrategy;

public class PaymentType{
    protected PayStrategy payStrategy;

    public PaymentType(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    protected void pay(){
        payStrategy.pay();
    }

    protected void setPayStrategy(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }
}