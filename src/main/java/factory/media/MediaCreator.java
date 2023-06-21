package factory.media;

/**
 * @author
 */
public class MediaCreator {

  protected Media createMedia(ResultSet res) {
    // 1. Lấy thông tin chung cho các loại media
    int id = res.getInt("id");
    String title = res.getString("title");
    int quantity = res.getInt("quantity");
    String category = res.getString("category");
    String imageUrl = res.getString("imageUrl");
    int price = res.getInt("price");
    String type = res.getString("type");

    // 2. Tạo đối tượng media cha
    Media media = new Media(id, title, quantity, category, imageUrl, price, type);

    // 3. Lấy đối tượng media tương ứng với type
    String className = type + "Creator";
    Class mediaCreator = Class.forName(className);
    return mediaCreator.createMedia(media);
  }
}
