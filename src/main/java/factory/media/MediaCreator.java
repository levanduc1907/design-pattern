package factory.media;

/**
 * @author
 */
public abstract class MediaCreator {

  protected Media createMedia(ResultSet res) {
    return new Media(
      res.getInt("id"),
      res.getString("title"),
      res.getInt("quantity"),
      res.getString("category"),
      res.getString("imageUrl"),
      res.getInt("price"),
      res.getString("type")
    );
  }
}
