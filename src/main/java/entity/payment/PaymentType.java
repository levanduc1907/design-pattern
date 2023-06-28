package entity.payment;

import strategy.payment.PaymentStrategy;

public class PaymentType{
    protected PaymentStrategy paymentStrategy;

    public PaymentType(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    protected void pay(){
        paymentStrategy.pay();
    }

    protected void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
}