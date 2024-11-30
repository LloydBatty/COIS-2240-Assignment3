// File Name : 			Transaction.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Sunday, December 1, 2024
// Purpose: 			This class performs the actions of borrowing and
//						returning books
//						Also gets current Date and Time
//

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
	
    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            //send details to be logged
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            //send details to be logged
            saveTransaction(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    // Saves the Transactions Details to text file
    public void saveTransaction(String transactionDetails) {
    	//Try to create the log text file
    	try {
    		File transactionsTXT = new File("transactions.txt");
    		if (transactionsTXT.createNewFile()) {
    			//Log File was created
    		}
    		else {
    			//File already exists
    		}
    	} catch (IOException e) {
    		System.out.println("Error logging file");
    	}
    	//Try to write the transaction details to txt file
    	try {
    		FileWriter logWriter = new FileWriter("transactions.txt", true);
    		logWriter.write("\n");
    		logWriter.write(transactionDetails);
    		logWriter.close();
    		//Wrote details to file
    	} catch (IOException e) {
    		System.out.println("Error writing to transaction log file");
    	}
    }//saveTransaction done
    
    // Display All Transaction History to User
    public void displayTransactionHistory() {
    	//Try to open and print contents of txt file
    	try {
    		File myFile = new File("transactions.txt");
    		Scanner myReader = new Scanner(myFile);
    		while (myReader.hasNextLine()) {
    			String transactionData = myReader.nextLine();
    			System.out.println(transactionData);
    		}
    		myReader.close();
    	} catch (FileNotFoundException e) {
    		System.out.println("Error displaying transaction log file");
    	}
    	
    }//end of displayTransactionHistory
    
}//end transaction class