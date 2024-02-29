package service;

import model.Library;
import model.User;
     public interface LibraryService {

          public void giveBook(String titleOfBook, Library library);

          public void giveBookFIFO(String titleOfBook, Library library);

     }
