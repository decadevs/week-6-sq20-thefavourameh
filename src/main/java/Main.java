import enums.Role;
import model.Book;
import model.Library;
import model.User;
import service.BorrowerService;
import service.LibraryService;
import service.impl.BorrowerServiceImpl;
import service.impl.LibraryServiceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

                //ADDING USERS
                User user1 = new User("Jnr Student Favour Ameh", Role.JNR_STUDENT, new ArrayList<>());
                User user2 = new User("Teacher Manasseh Obaje", Role.TEACHER, new ArrayList<>());
                User user3 = new User("Snr Student Destiny Etiko", Role.SNR_STUDENT, new ArrayList<>());
                User user4 = new User("Snr Student Mercy Johnson", Role.SNR_STUDENT, new ArrayList<>());
                User user5 = new User("Librarian", Role.LIBRARIAN, new ArrayList<>());

                Book book1 = new Book("Java Methods", "James Bloch", 3);
                Book book2 = new Book("Looping in Java", "Damian Wonder", 5);
                Book book3 = new Book("Intro to OOP", "Mary-Ann Ukpengit ", 8);


                Library library = new Library("Central Library", new ArrayList<>(), new PriorityQueue<>(), new LinkedList<>(), new User());


                library.setListOfBooks(List.of(book1, book2, book3));

                LibraryService libraryService = new LibraryServiceImpl();
                BorrowerService borrowerService = new BorrowerServiceImpl();


                //GIVE BOOK
                borrowerService.requestBook("Looping in Java", user1, library);
                borrowerService.requestBook("Looping in Java", user2, library);
                borrowerService.requestBook("Looping in Java", user3, library);

                System.out.println("*********************************************************");
                libraryService.giveBook("Looping in Java", library);

                System.out.println("*********************************************************");

                //GIVE BOOK FIFO
                borrowerService.requestBookFIFO("Java Methods", user1, library);
                borrowerService.requestBookFIFO("Java Methods", user2, library);
                borrowerService.requestBookFIFO("Java Methods", user3, library);
                borrowerService.requestBookFIFO("Java Methods", user4, library);

                libraryService.giveBookFIFO("Java Methods", library);


            }
        }