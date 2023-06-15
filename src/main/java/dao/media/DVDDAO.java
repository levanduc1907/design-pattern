package dao.media;

import entity.db.AIMSDB;
import entity.media.DVD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author
 */
public class DVDDAO extends MediaDAO {

    public DVDDAO(){
        mediaCreator = new DVDCreator();
    }

    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.DVD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = DVD.id " +
                "where Media.id = " + id + ";";
        ResultSet res = AIMSDB.getConnection().createStatement().executeQuery(sql);
        if(res.next()) {
            return mediaCreator.createMedia(res);
        } else {
            throw new SQLException();
        }
    }
}
