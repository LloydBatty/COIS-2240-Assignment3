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
//						Does not work as intended, but I tried 
//						TASK 3-2 really does not work

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
			Book Book100 = new Book(100, "Book100");
			assertTrue(library.addBook(Book100));
			
			Book Book999 = new Book(999, "Book999");
			assertTrue(library.addBook(Book999));			
			
			Book Book1000 = new Book(1000, "Book1000");
			assertFalse(library.addBook(Book1000));
			
			Book Book77 = new Book(77, "Book77");
			assertFalse(library.addBook(Book77));
			
			Book Book2000 = new Book(2000, "Book2000");
			assertFalse(library.addBook(Book2000));
		}
		catch (Exception e) {
			System.out.println("Exception throw and caught");
		}
	}
	
	
	//TASK 3-2 testBorrowReturn
	@Test
	public void testBorrowReturn() throws Exception {
		try {
			Book TestBook = new Book(555, "TestBook");
			Member TestMember = new Member(5, "TestMember");
			assertTrue(TestBook.isAvailable()); 
			
		//TODO: do stuff with the single transaction instance I need to get
			
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
