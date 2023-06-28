package entity.payment;

import strategy.payment.PaymentStrategy;

/**
 * @author
 */
public class CreditCard extends PaymentType {

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(PaymentStrategy paymentStrategy, String cardCode, String owner, String dateExpired, int cvvCode) {
        super(paymentStrategy);
        this.paymentStrategy = paymentStrategy;
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
