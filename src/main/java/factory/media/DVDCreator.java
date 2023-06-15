package factory.media;

/**
 * @author
 */
public class DVDCreator extends MediaCreator {

    @Override
    protected Media createMedia(ResultSet res){
        // from media table
        int id = res.getInt("id");
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
        return new DVD(id, title, type, price, category, quantity, discType, director, runtime, studio, subtitles, releasedDate, filmType);
    }
}