package service;
import model.Library;
import model.User;

public interface BorrowerService {
    public  void requestBook(String titleOfBook, User user, Library library);

    public void requestBookFIFO(String titleOfBook, User user, Library library);


}
