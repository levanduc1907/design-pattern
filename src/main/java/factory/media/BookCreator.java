package factory.media;

/**
 * @author
 */
public class BookCreator {

  protected Media createMedia(Media parentMedia) {
    // from Book table
    String sql = "SELECT * FROM Book where id = " + parentMedia.getId() + ";";
    Statement stm = AIMSDB.getConnection().createStatement();
    ResultSet res = stm.executeQuery(sql);

    Book book = null;
    if (res.next()) {
      String author = res.getString("author");
      String coverType = res.getString("coverType");
      String publisher = res.getString("publisher");
      Date publishDate = res.getDate("publishDate");
      int numOfPages = res.getInt("numOfPages");
      String language = res.getString("language");
      String bookCategory = res.getString("bookCategory");

      book = new Book(
        parentMedia.getId(),
        parentMedia.getTitle(),
        parentMedia.getCategory(),
        parentMedia.getPrice(),
        parentMedia.getQuantity(),
        parentMedia.getType(),
        author,
        coverType,
        publisher,
        publishDate,
        numOfPages,
        language,
        bookCategory
      );
    }

    return book;
  }
}
