package se.lexicon.model;

import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    public Book(String title, String author) {
        setId();
        setTitle(title);
        setAuthor(author);
        this.available = true;
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        setBorrower(borrower);
    }

    private void setId() {
        this.id = UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title can't be NULL or empty.");
        } else {
            this.title = title;
        }
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author can't be NULL or empty.");
        } else {
            this.author = author;
        }
    }

    public void setBorrower(Person borrower) {
        if (borrower != null) this.available = false;
        this.borrower = borrower;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBookInformation() {
        return "id: " + id + " title: " + title + " author: " + author + ", available: " + available;
    }
}