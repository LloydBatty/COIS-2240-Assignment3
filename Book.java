// File Name : 			Book.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Wednesday, December 4, 2024
// Purpose: 			This class contains the information about the Books
//						Each book has an ID, name, and availability
//

public class Book {
    private int id;
    private String title;
    private boolean available;

    public Book(int id, String title) throws Exception {
    	// call the Validity check before other details
    	//  throw exception if invalid ID
    	if (this.isValidId(id) != true) {
    		throw new Exception("Exception: Sorry, the ID provided is INVALID");
    	}
    	
        this.id = id;
        this.title = title;
        this.available = true;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    // Method to borrow the book
    public void borrowBook() {
        if (available) {
            available = false;
        }
    }

    // Method to return the book
    public void returnBook() {
        available = true;
    }

    
    // Method to check if a book id is valid
    public boolean isValidId(int id) {
        return id >= 100 && id <= 999;
    }
    
    
}




