package factory.media;

/**
 * @author
 */
public class DVDCreator {

  protected Media createMedia(Media parentMedia) {
    // from DVD table
    String sql = "SELECT * FROM DVD where id = " + parentMedia.getId() + ";";
    Statement stm = AIMSDB.getConnection().createStatement();
    ResultSet res = stm.executeQuery(sql);

    DVD dvd = null;
    if (res.next()) {
      String discType = res.getString("discType");
      String director = res.getString("director");
      int runtime = res.getInt("runtime");
      String studio = res.getString("studio");
      String subtitles = res.getString("subtitle");
      Date releasedDate = res.getDate("releasedDate");
      String filmType = res.getString("filmType");
      dvd =
        new DVD(
          parentMedia.getId(),
          parentMedia.getTitle(),
          parentMedia.getCategory(),
          parentMedia.getPrice(),
          parentMedia.getQuantity(),
          parentMedia.getType(),
          discType,
          director,
          runtime,
          studio,
          subtitles,
          releasedDate,
          filmType
        );
    }
    return dvd;
  }
}
