package service.impl;

import enums.Role;
import model.Book;
import model.Library;
import model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerServiceImplTest {

    @Test
    void requestBook() {
        BorrowerServiceImpl borrowerServiceImpl = new BorrowerServiceImpl();
        User user = new User();

        Library library = new Library();
        library.setBorrowers(new PriorityQueue<>());

        borrowerServiceImpl.requestBook("Book Title", user, library);
        assertEquals(1, library.getBorrowers().size());
    }

    @Test
    void requestBookFIFO() {
        BorrowerServiceImpl borrowerServiceImpl = new BorrowerServiceImpl();
        User user = new User();

        Library library = new Library();
        library.setUserQueueFIFO(new LinkedList<>());

        borrowerServiceImpl.requestBookFIFO("Book Title", user, library);
        assertEquals(1, library.getUserQueueFIFO().size());
    }
}




