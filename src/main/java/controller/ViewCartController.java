package controller;

import java.sql.SQLException;

import entity.cart.Cart;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */
public class ViewCartController extends BaseController{
    
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
    	/**
    	 * Common coupling liên quan đến cartInstance của SessionInformation
    	 */
        SessionInformation.cartInstance.checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
    	/**
    	 * Common coupling liên quan đến cartInstance của SessionInformation
    	 */
        int subtotal = SessionInformation.cartInstance.calSubtotal();
        return subtotal;
    }

}
