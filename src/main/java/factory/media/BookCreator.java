package factory.media;

/**
 * @author
 */
public class BookCreator extends MediaCreator {

  @Override
  protected Media createMedia(ResultSet res) {
    // from Media table
    int id = res.getInt("id");
    String title = "";
    String type = res.getString("type");
    int price = res.getInt("price");
    String category = res.getString("category");
    int quantity = res.getInt("quantity");

    // from Book table
    String author = res.getString("author");
    String coverType = res.getString("coverType");
    String publisher = res.getString("publisher");
    Date publishDate = res.getDate("publishDate");
    int numOfPages = res.getInt("numOfPages");
    String language = res.getString("language");
    String bookCategory = res.getString("bookCategory");
    return new Book(
      id,
      title,
      category,
      price,
      quantity,
      type,
      author,
      coverType,
      publisher,
      publishDate,
      numOfPages,
      language,
      bookCategory
    );
  }
}
