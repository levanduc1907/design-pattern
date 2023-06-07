package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * Sửa để áp dụng singleton ở đây
 */
/**
 * @author
 */
public class SessionInformation {
    private static User mainUser = User.getInstance();
    private static Cart cartInstance = Cart.getInstance();
    private static LocalDateTime expiredTime;

    public static User getMainUser(){
        return mainUser;
    }

    public static Cart getCartInstance(){
        return cartInstance;
    }

    public static LocalDateTime getExpiredTime(){
        return expiredTime;
    }

    public static void setExpiredTime(LocalDateTime expiredTime){
        this.expiredTime = expiredTime;
    }

}
