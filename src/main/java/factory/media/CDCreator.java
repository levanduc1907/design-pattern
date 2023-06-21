package factory.media;

/**
 * @author
 */
public class CDCreator {

  protected Media createMedia(Media parentMedia) {
    // from CD table
    String sql = "SELECT * FROM CD where id = " + parentMedia.getId() + ";";
    Statement stm = AIMSDB.getConnection().createStatement();
    ResultSet res = stm.executeQuery(sql);

    CD cd = null;
    if (res.next()) {
      // from CD table
      String artist = res.getString("artist");
      String recordLabel = res.getString("recordLabel");
      String musicType = res.getString("musicType");
      Date releasedDate = res.getDate("releasedDate");
      cd =
        new CD(
          parentMedia.getId(),
          parentMedia.getTitle(),
          parentMedia.getCategory(),
          parentMedia.getPrice(),
          parentMedia.getQuantity(),
          parentMedia.getType(),
          artist,
          recordLabel,
          musicType,
          releasedDate
        );
    }
    return cd;
  }
}
