package se.lexicon;

import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // Create a book instance
        Book book = new Book("Jane Doe in Paris", "John Doe");
        // Display book information
        String dpBook = book.getBookInformation();
        System.out.println("dpBook = " + dpBook);

        // Create a person instance
        Person person = new Person("Emma", "Åstrand");
        // Display person information
        String dpPerson = person.getPersonInformation();
        System.out.println("dpPerson = " + dpPerson);
        System.out.println();

        // Loan a book to the person
        person.loanBook(book);

        // Display person information after borrowing a book
        String dpPersonLoan = person.getPersonInformation();
        System.out.println("dpPersonLoan = " + dpPersonLoan);
        // Display book information after borrowing a book
        String dpBookLoan = book.getBookInformation();
        System.out.println("dpBookLoan = " + dpBookLoan);
        System.out.println();

        // Return the borrowed book
        person.returnBook(book);

        // Display person information after returning the book
        String dpPersonReturn = person.getPersonInformation();
        System.out.println("dpPersonReturn = " + dpPersonReturn);
        // Display book information after borrowing a book
        String dpBookReturn = book.getBookInformation();
        System.out.println("dpBookReturn = " + dpBookReturn);
    }
}