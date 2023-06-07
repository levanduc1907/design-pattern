package entity.payment;

/**
 * @author
 */
public class DomesticCard extends Card {

    private String type;
    private String issuingBank;
    private int cardNumber;
    private String validFromDate;
    private String owner;

    public DomesticCard(String type, String issuingBank, int cardNumber, String validFromDate, String owner) {
        this.type = type;
        this.issuingBank = issuingBank;
        this.cardNumber = cardNumber;
        this.validFromDate = validFromDate;
        this.owner = owner;
    }
}