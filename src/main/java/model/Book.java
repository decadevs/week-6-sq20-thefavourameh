package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Book {
    private String bookTitle;
    private String author;
    private int noOfCopies;

    public Book(String bookTitle, String author, int noOfCopies) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.noOfCopies = noOfCopies;
    }

}
