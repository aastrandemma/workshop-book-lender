package se.lexicon.model;

import java.util.Arrays;

public class Person {
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private Book[] booksBorrowed;

    public Person(String firstName, String lastName) {
        this.id = getNextId();
        setFirstName(firstName);
        setLastName(lastName);
        this.booksBorrowed = new Book[0];
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name can't be NULL or empty.");
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name can't be NULL or empty.");
        } else {
            this.lastName = lastName;
        }
    }

    private static int getNextId() {
        return sequencer++;
    }

    public String getPersonInformation() {
        return "id: " + id + ", name: " + firstName + " " + lastName + " numberOfBookLoaned: " + booksBorrowed.length;
    }

    public void loanBook(Book book) {
        if (book.isAvailable()) {
            booksBorrowed = Arrays.copyOf(booksBorrowed, booksBorrowed.length + 1);
            booksBorrowed[booksBorrowed.length - 1] = book;
            book.setAvailable(false);
        } else {
            throw new IllegalArgumentException("Book is borrowed by someone else.");
        }
    }

    public void returnBook(Book book) {
        if (!book.isAvailable()) {
            Book[] tmpBooksBorrowed = Arrays.copyOf(booksBorrowed, booksBorrowed.length - 1);
            int i = 0;
            for (Book books: booksBorrowed) {
                if(!books.getTitle().equalsIgnoreCase(book.getTitle())) {
                    tmpBooksBorrowed[i] = books;
                    i++;
                }
            }
            booksBorrowed = tmpBooksBorrowed;
            book.setAvailable(true);
        } else {
            throw new IllegalArgumentException("Book isn't borrowed.");
        }
    }
}