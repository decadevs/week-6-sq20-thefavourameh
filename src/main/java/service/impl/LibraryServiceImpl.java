package service.impl;
import exception.LibraryException;
import lombok.*;
import model.Book;
import model.Library;
import model.User;
import service.LibraryService;

import java.util.*;


@Data


    public class LibraryServiceImpl implements LibraryService {



    @Override
    public void giveBook(String titleOfBook, Library library) {
        library.getListOfBooks().stream()
                .filter(book -> book.getBookTitle().equalsIgnoreCase(titleOfBook))
                .forEach(book -> {
                    library.getBorrowers().stream()
                            .filter(user -> book.getNoOfCopies() > 0)
                            .forEach(user -> {
                                book.setNoOfCopies(book.getNoOfCopies() - 1);
                                List<Book> borrowedBooks = user.getBorrowedBooks();
                                borrowedBooks.add(book);
                                user.setBorrowedBooks(borrowedBooks);
                                System.out.println(user.getName() + " has borrowed " + titleOfBook);
                            });
                });
    }


    @Override
    public void giveBookFIFO(String titleOfBook, Library library) {
        Queue<User> userQueueFIFO = library.getUserQueueFIFO();
        if (userQueueFIFO != null) {
            userQueueFIFO.forEach(user -> {
                library.getListOfBooks().stream().filter(book -> book.getBookTitle().equalsIgnoreCase(titleOfBook))
                .forEach(book -> {
                    if (book.getNoOfCopies() > 0) {
                        book.setNoOfCopies(book.getNoOfCopies() - 1);
                        List<Book> borrowedBooks = user.getBorrowedBooks();
                        borrowedBooks.add(book);
                        user.setBorrowedBooks(borrowedBooks);
                        System.out.println(user.getName() + " has borrowed " + titleOfBook);
                    } else {
                        try {
                            System.out.println("Book is not available");
                        } catch (Exception e) {
                            throw new LibraryException("Book is not available");
                        }
                    }
                });
            });
        }
    }
}


