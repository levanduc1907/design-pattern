package entity.payment;

/**
 * Vi phạm DIP, OCP: Lớp PaymentTransaction phụ thuộc trực tiếp lớp CreditCard. Trong tương lai, phát sinh thêm hình
 * thức thanh toán mới (sử dụng thẻ nội địa) thì lớp PaymentTransaction cũng cần sửa đổi
 */
public class PaymentTransaction {
	private String errorCode;
	private CreditCard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;

	/**
	 * Vi phạm OCP: Constructor PaymentTransaction mới chỉ có phương thức thanh toán
	 * với Credit Card, về sau có nhiều phương thức khác sẽ phải sửa lại mã nguồn
	 */
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
			int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
