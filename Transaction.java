// File Name : 			Transaction.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Sunday, December 1, 2024
// Purpose: 			This class performs the actions of borrowing and
//						returning books
//						Also gets current Date and Time

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	//Making the class a SINGLETON
	// Private static instance
	private static Transaction instance;

	// Private Constructor
	private Transaction() {}
	
	// Public Accessor Method
	public static Transaction getTransaction() {
		if (instance == null) {
			instance = new Transaction();
		}
		return instance;
	}
	
	//I removed static
    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    //I removed static
    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    //I removed static
    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    
}