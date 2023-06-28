package subsystem.interbank;

import entity.payment.PaymentType;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(PaymentType paymentType, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(PaymentType paymentType, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(paymentType, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
