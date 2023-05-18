package controller;

import common.exception.ExpiredSessionException;
import common.exception.FailLoginException;
import dao.user.UserDAO;
import entity.user.User;
import utils.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;



/**
 * @author
 */
public class AuthenticationController extends BaseController {

    public boolean isAnonymousSession() {
        try {
            getMainUser();
            return false;
        } catch (Exception ex) {
            return true;
        }
    }

    /**
     * Vi phạm SRP: Phương thức getMainUser không liên quan đến các phương thức khác
     * trong class, nên tách vào trong 1 class riềng
     */
    public User getMainUser() throws ExpiredSessionException {
        if (SessionInformation.mainUser == null || SessionInformation.expiredTime == null
                || SessionInformation.expiredTime.isBefore(LocalDateTime.now())) {
            logout();
            throw new ExpiredSessionException();
        } else
            return SessionInformation.mainUser.cloneInformation();
    }

    public void login(String email, String password) throws Exception {
        try {
            User user = new UserDAO().authenticate(email, md5(password));
            if (Objects.isNull(user))
                throw new FailLoginException();
            SessionInformation.mainUser = user;
            SessionInformation.expiredTime = LocalDateTime.now().plusHours(24);
        } catch (SQLException ex) {
            throw new FailLoginException();
        }
    }

    public void logout() {
        SessionInformation.mainUser = null;
        SessionInformation.expiredTime = null;
    }

    /**
     * Trong tương lai, khi muốn sử dụng một thuật toán khác để mã hóa mật khẩu
     * thì sẽ cần sửa đổi lớp controller
     * => Vi phạm nguyên tắc mở đóng.
     * => Giải pháp: Tạo ra một lớp trừu tượng cho các thuật toán mã hóa. Các lớp kế
     * thừa sẽ thực thi thuật toán
     * mã hóa cụ thể
     */

    /**
     * Return a {@link String String} that represents the cipher text
     * encrypted by md5 algorithm.
     *
     * @param message - plain text as {@link String String}.
     * @return cipher text as {@link String String}.
     */
    private String md5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes(StandardCharsets.UTF_8));
            // converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            digest = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Utils.getLogger(Utils.class.getName());
            digest = "";
        }
        return digest;
    }

}
