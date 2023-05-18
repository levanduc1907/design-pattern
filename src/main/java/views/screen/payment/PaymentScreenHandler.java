package views.screen.payment;

import controller.PaymentController;
import entity.invoice.Invoice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;
import views.screen.popup.PopupScreen;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class PaymentScreenHandler extends BaseScreenHandler {

	private static final Logger LOGGER = Utils.getLogger(PaymentScreenHandler.class.getName());

	@FXML
	private Button btnConfirmPayment;

	@FXML
	private ImageView loadingImage;

	private Invoice invoice;

	@FXML
	private Label pageTitle;

	@FXML
	private TextField cardNumber;

	@FXML
	private TextField holderName;

	@FXML
	private TextField expirationDate;

	@FXML
	private TextField securityCode;
/**
 * Vi phạm OCP: Trong tương lai, khi thay đổi yêu cầu khi load giao diện (thay vì hiển thị thông báo lỗi trên màn hình popup
 * thì sẽ hiển thị trực tiếp lỗi trên phía trên cùng của các trang) sẽ cần sửa đổi trực tiếp cách xử lý lỗi load
 * trong constructor của lớp
 */
	public PaymentScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		try {
			setupData(invoice);
			setupFunctionality();
		} catch (IOException ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error("Error when loading resources.");
		} catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			PopupScreen.error(ex.getMessage());
		}
	}

	protected void setupData(Object dto) throws Exception {
		this.invoice = (Invoice) dto;
	}

	protected void setupFunctionality() throws Exception {
		btnConfirmPayment.setOnMouseClicked(e -> {
			try {
				confirmToPayOrder();
				((PaymentController) getBController()).emptyCart();
			} catch (Exception exp) {
				System.out.println(exp.getStackTrace());
			}
		});
	}

	void confirmToPayOrder() throws IOException{
		String contents = "pay order";
		PaymentController ctrl = (PaymentController) getBController();
		Map<String, String> response = ctrl.payOrder(invoice.getAmount(), contents, cardNumber.getText(), holderName.getText(),
				expirationDate.getText(), securityCode.getText());

		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, ViewsConfig.RESULT_SCREEN_PATH, response);
		resultScreen.setPreviousScreen(this);
		resultScreen.setHomeScreenHandler(homeScreenHandler);
		resultScreen.setScreenTitle("Result Screen");
		resultScreen.show();
	}
}