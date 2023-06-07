package factory.media;

/**
 * @author
 */
public class BookCreator extends MediaCreator {

    @Override
    protected Media createMedia(){
        return new Book();
    }
    
    protected Media createMedia(int id, String title, String category, int price, int quantity, String type, String author,
            String coverType, String publisher, Date publishDate, int numOfPages, String language,
            String bookCategory){
                return new Book(id, title, category, price, quantity, type, author, coverType, publisher,
                publishDate, numOfPages, language, bookCategory);
            }
}