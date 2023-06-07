package factory.media;

/**
 * @author
 */
public class DVDCreator extends MediaCreator {

    @Override
    protected Media createMedia(){
        return new DVD();
    }

    protected Media createMedia(int id, String title, String category, int price, int quantity, String type, String discType,
            String director, int runtime, String studio, String subtitles, Date releasedDate, String filmType){
                return new DVD(id, title, category, price, quantity, type, discType, director, runtime, studio, subtitles, releasedDate, filmType);
            }
    
}