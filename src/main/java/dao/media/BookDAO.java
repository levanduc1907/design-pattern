package dao.media;

import entity.db.AIMSDB;
import entity.media.Book;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author
 */
public class BookDAO extends MediaDAO {

    public BookDAO(){
        mediaCreator = new BookCreator();
    }

    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.Book " +
                "INNER JOIN aims.Media " +
                "ON Media.id = Book.id " +
                "where Media.id = " + id + ";";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {
            return mediaCreator.createMedia(res);

        } else {
            throw new SQLException();
        }
    }
}
