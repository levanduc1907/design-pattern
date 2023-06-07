package factory.media;

/**
 * @author
 */
public class CDCreator extends MediaCreator {

    @Override
    protected Media createMedia(){
        return new CD();
    }

    protected Media createMedia(int id, String title, String category, int price, int quantity, String type, String artist,
            String recordLabel, String musicType, Date releasedDate){
                return new CD(id, title, category, price, quantity, type, artist, recordLabel, musicType, releasedDate);
            }
    
}