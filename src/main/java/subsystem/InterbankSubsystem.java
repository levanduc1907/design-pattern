package subsystem;

import entity.payment.PaymentType;
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(PaymentType, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(PaymentType paymentType, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(paymentType, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(PaymentType, int,
	 *      String)
	 */
	public PaymentTransaction refund(PaymentType paymentType, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(paymentType, amount, contents);
		return transaction;
	}
}
