package entity.payment;

import strategy.payment.PayStrategy;

/**
 * @author
 */
public class CreditCard extends PaymentType {

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(PayStrategy payStrategy, String cardCode, String owner, String dateExpired, int cvvCode) {
        super(payStrategy);
        this.payStrategy = payStrategy;
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
