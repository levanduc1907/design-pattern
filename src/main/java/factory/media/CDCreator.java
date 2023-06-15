package factory.media;

/**
 * @author
 */
public class CDCreator extends MediaCreator {

  @Override
  protected Media createMedia(ResultSet res) {
    // from media table
    int id = res.getInt("id");
    String title = "";
    String type = res.getString("type");
    int price = res.getInt("price");
    String category = res.getString("category");
    int quantity = res.getInt("quantity");

    // from CD table
    String artist = res.getString("artist");
    String recordLabel = res.getString("recordLabel");
    String musicType = res.getString("musicType");
    Date releasedDate = res.getDate("releasedDate");
    return new CD(
      id,
      title,
      category,
      price,
      quantity,
      type,
      artist,
      recordLabel,
      musicType,
      releasedDate
    );
  }
}
