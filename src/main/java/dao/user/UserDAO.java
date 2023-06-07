package dao.user;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author
 */
public class UserDAO {
    private static UserDAO userDAO = new UserDAO();
    
    private UserDAO(){

    }

    public static UserDAO getInstance(){
        return userDAO;
    }

    public void authenticate(String email, String encryptedPassword) throws SQLException {
        String sql = "SELECT * FROM User " +
                "where email = '" + email + "' and encrypted_password = '" + encryptedPassword + "'";
        ResultSet res =  AIMSDB.getConnection().createStatement().executeQuery(sql);
        if(res.next()) {
            User user = User.getInstance();
            user.setId(res.getInt("id"));
            user.setName(res.getString("name"));
            user.setEmail(res.getString("email"));
            user.setAddress(res.getString("address"));
            user.setPhone(res.getString("phone"));
        } else {
            throw new SQLException();
        }
    }
}
