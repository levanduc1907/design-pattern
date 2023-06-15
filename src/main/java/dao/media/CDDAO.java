package dao.media;

import entity.db.AIMSDB;
import entity.media.CD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author
 */
public class CDDAO extends MediaDAO {

    public CDDAO(){
        mediaCreator = new CDCreator();
    }

    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.CD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = CD.id " +
                "where Media.id = " + id + ";";

        ResultSet res = AIMSDB.getConnection().createStatement().executeQuery(sql);
        if(res.next()) {
            return mediaCreator.createMedia(res);
        } else {
            throw new SQLException();
        }
    }
}
