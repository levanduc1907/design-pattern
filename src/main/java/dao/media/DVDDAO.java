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
/**
 * Vi phạm LSP: Khi không tìm thấy Media nào có id cho trước, thay vì trả về null như hành vi getMediaById trong lớp cha
 * MediaDAO thì phương thức getMediaById lại tung ra một ngoại lệ
 * => Hành vi của lớp cha đã bị sửa đổi để không hoạt động trong trường hợp không tìm thấy
 */
    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.DVD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = DVD.id " +
                "where Media.id = " + id + ";";
        ResultSet res = AIMSDB.getConnection().createStatement().executeQuery(sql);
        if(res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from DVD table
            String discType = res.getString("discType");
            String director = res.getString("director");
            int runtime = res.getInt("runtime");
            String studio = res.getString("studio");
            String subtitles = res.getString("subtitle");
            Date releasedDate = res.getDate("releasedDate");
            String filmType = res.getString("filmType");

            return new DVD(id, title, category, price, quantity, type, discType, director, runtime, studio, subtitles, releasedDate, filmType);

        } else {
            throw new SQLException();
        }
    }
}
