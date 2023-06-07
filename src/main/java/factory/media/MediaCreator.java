package factory.media;

/**
 * @author
 */
public abstract class MediaCreator {

    protected Media createMedia(){
        return new Media();
    }

    protected Media createMedia(int id, String title, String category, int price, int quantity, String type){
        return new Media(id, title, category, price, quantity, type);
    }

}