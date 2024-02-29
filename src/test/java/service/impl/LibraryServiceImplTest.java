package service.impl;
import enums.Role;
import model.Book;
import model.Library;
import model.User;
import org.junit.jupiter.api.Test;
import service.BorrowerService;
import service.LibraryService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceImplTest {
    private LibraryServiceImpl libraryService;

    @Test
    public void testGiveBook() {
        User user1 = new User("Snr Student Princess Baba", Role.SNR_STUDENT, new ArrayList<>());
        User user2 = new User("Jnr Student Sammie Damina", Role.JNR_STUDENT, new ArrayList<>());
        User user3 = new User("Teacher Maryam Yashim", Role.TEACHER, new ArrayList<>());


        Book book1 = new Book("Java Methods", "James Bloch", 3);
        Book book2 = new Book("Looping in Java", "Damian Wonder", 5);
        Book book3 = new Book("Intro to OOP", "MaryAnn Martins", 8);


        Library library = new Library("Central Library", new ArrayList<>(), new PriorityQueue<>(), new LinkedList<>(), new User());


        library.setListOfBooks(List.of(book1, book2, book3));

        LibraryService libraryService = new LibraryServiceImpl();
        BorrowerService borrowerService = new BorrowerServiceImpl();


        //GIVE BOOK
        borrowerService.requestBook("Looping in Java", user1, library);
        borrowerService.requestBook("Looping in Java", user2, library);
        borrowerService.requestBook("Looping in Java", user3, library);

        libraryService.giveBook("Looping in Java", library);
        assertEquals(1, user1.getBorrowedBooks().size());
        assertEquals("Teacher Maryam Yashim", library.getBorrowers().peek().getName());
    }


@Test
public void testGiveBookFIFO() {
    User user1 = new User("Snr Student Princess Baba", Role.SNR_STUDENT, new ArrayList<>());
    User user2 = new User("Jnr Student Sammie Damina", Role.JNR_STUDENT, new ArrayList<>());
    User user3 = new User("Teacher Maryam Yashim", Role.TEACHER, new ArrayList<>());


    Book book1 = new Book("Java Methods", "James Bloch", 3);
    Book book2 = new Book("Looping in Java", "Damian Wonder", 5);
    Book book3 = new Book("Intro to OOP", "MaryAnn Martins", 8);



    Library library = new Library("Central Library", new ArrayList<>(), new PriorityQueue<>(), new LinkedList<>(), new User());


    library.setListOfBooks(List.of(book1, book2, book3));

    LibraryService libraryService = new LibraryServiceImpl();
    BorrowerService borrowerService = new BorrowerServiceImpl();

    //GIVE BOOK FIFO
    borrowerService.requestBookFIFO("Java Methods", user1, library);
    borrowerService.requestBookFIFO("Java Methods", user2, library);
    borrowerService.requestBookFIFO("Java Methods", user3, library);

    libraryService.giveBookFIFO("Java Methods", library);
    assertEquals(1, user1.getBorrowedBooks().size());
    assertEquals("Snr Student Princess Baba", library.getUserQueueFIFO().peek().getName());

}

}
