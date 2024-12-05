// File Name : 			LibraryManagementTest.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Wednesday, December 4, 2024
// Purpose: 			This is the main test file
//						
//						I had to use JUnit 5, as my JUnit 4 will
//						not work and never runs.
//

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;

class LibraryManagementTest {
// I used JUnit5 has myJUnit4 will not work.

	//our testing library?
	private Library library = new Library();
	
	@Before
	public void setUp() {
		//Does not run if I set up here
	}
	
	
	//TASK 3-1 testBookId
	@Test
	public void testBookId() throws Exception {
		try {
			//Testing Boundary Cases for Books
			Book Book100 = new Book(100, "Book100");
			assertTrue(library.addBook(Book100));
			//Asserted Booked created successfully
			
			Book Book999 = new Book(999, "Book999");
			assertTrue(library.addBook(Book999));			
			//Asserted Booked created successfully			
			
			Book Book1000 = new Book(1000, "Book1000");
			assertFalse(library.addBook(Book1000));
			//Asserted Booked DID NOT CREATE
			
			//Testing Outside Boundary Cases for Books
			Book Book77 = new Book(77, "Book77");
			assertFalse(library.addBook(Book77));
			//Asserted Booked DID NOT CREATE			
			
			Book Book2000 = new Book(2000, "Book2000");
			assertFalse(library.addBook(Book2000));
			//Asserted Booked DID NOT CREATE
		}
		catch (Exception e) {
			System.out.println("Exception throw and caught");
		}
	}
	
	
	//TASK 3-2 testBorrowReturn
	@Test
	public void testBorrowReturn() throws Exception {
		try {
			//instantiating test Book and Member
			Book TestBook = new Book(555, "TestBook");
			Member TestMember = new Member(5, "TestMember");
			assertTrue(TestBook.isAvailable()); 
			//Asserted Book is Available
			
			Transaction TransactionI = Transaction.getTransaction();	
			assertTrue(TransactionI.borrowBook(TestBook, TestMember));
			//Asserted Book Borrow transaction succeeded 
			
			assertFalse(TestBook.isAvailable());
			//Asserted Book is UNavailable
			
			assertFalse(TransactionI.borrowBook(TestBook, TestMember));
			//Asserted 2nd Book Borrow transaction is UNsucessful
			
			assertTrue(TransactionI.returnBook(TestBook, TestMember));
			//Asserted Book Return transaction succeeded 

			assertTrue(TestBook.isAvailable());
			//Asserted Book is available from returning
			
			assertFalse(TransactionI.returnBook(TestBook, TestMember));
			//Asserted 2nd Book Return is UNsucessful

		}
		catch (Exception e) {
			System.out.println("Exception throw and caught");
		}
	}
	
	
	//TASK 3-3 testSingletonTransaction
	@Test
	public void testSingletonTransaction() throws Exception {
		try {
			Constructor<Transaction> constructor = Transaction.class.getDeclaredConstructor();
			assertTrue(constructor.getModifiers() == 2);
		}
		catch (Exception e) {
			System.out.println("Exception throw and caught");
		}
	}
	

}
