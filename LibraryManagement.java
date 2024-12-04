// File Name : 			LibraryManagement.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Wednesday, December 4, 2024
// Purpose: 			Main actor of the system
//						This java file contains the main to perform
//						Library Management actions
//

import java.util.Scanner;

public class LibraryManagement {
    private Library library = new Library();

    public static void main(String[] args) {
        new LibraryManagement().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("===========================");
            System.out.println("Library Management System");
            System.out.println("1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.println("===========================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: // ADD MEMBER
                    System.out.print("Enter member ID: ");
                    int id = scanner.nextInt();
                	System.out.print("Enter member name: ");
                    String name = scanner.next();
                    
                    scanner.nextLine();

                    Member newMember = new Member(id, name);
                    library.addMember(newMember);
                    System.out.println("Member added successfully.");
                    break;
                
                case 2: // ADD BOOK
                    System.out.print("Enter book ID: ");
                    id = scanner.nextInt();
                	System.out.print("Enter book title: ");
                    String title = scanner.next();
                    
                    scanner.nextLine();
                    
                    //Try Catch to handle possible invalid ID
                    try {
                    	Book newBook = new Book(id, title);
                    	library.addBook(newBook);
            		}
                    catch(Exception e) {
                    	System.out.println("Error: The ID provided is invalid");
                    }
                    
                    System.out.println("Book added to library successfully.");
                    break;
                    
                case 3: // BORROW
                	System.out.println("\n--- Available Members ---");
                    for (Member member : library.getMembers()) {
                        System.out.println(member.getId() + ". " + member.getName());
                    }
                    
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    
                    System.out.println("\n--- Available Books ---");
                    for (Book book : library.getBooks()) {
                        if (book.isAvailable())
                            System.out.println(book.getId() + ". " + book.getTitle());
                    }
                    
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    
                    scanner.nextLine();

                    Member member = library.findMemberById(memberId);
                    Book book = library.findBookById(bookId);

                    if (member != null && book != null) {
                    	//I use the Singleton Instance of Transaction for BORROW
                    	Transaction.getTransaction().borrowBook(book, member);
                    } else {
                        System.out.println("Invalid member or book ID.");
                    }
                    break;
                    
                case 4: // RETURN
                	System.out.print("Enter member ID: ");
                    memberId = scanner.nextInt();
                    
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    
                    scanner.nextLine();

                    member = library.findMemberById(memberId);
                    book = library.findBookById(bookId);

                    if (member != null && book != null) {
                    	//I use the Singleton Instance of Transaction for RETURN
                    	Transaction.getTransaction().returnBook(book, member);
                    } else {
                        System.out.println("Invalid member or book ID.");
                    }
                    break;
                    
                case 5: // VIEW BORROWED BOOKS
                	System.out.print("Enter member ID: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine();

                    Member specificMember = library.findMemberById(memberId);
                    
                    if (specificMember != null) {
                        System.out.println("Books borrowed by " + specificMember.getName() + ":");
                        for (Book bk : specificMember.getBorrowedBooks()) {
                            System.out.println(" - " + bk.getTitle());
                        }
                    } else {
                        System.out.println("Invalid member ID.");
                    }
                    break;
                    
                case 6: // VIEW TRANSACTION HISTORY
                	//I use the Singleton Instance of Transaction for HISTORY
                	Transaction.getTransaction().displayTransactionHistory();
                    break;
                    
                case 7: // EXIT
                    System.out.println("Exiting. Good Bye..");
                    running = false;
                    break;
                    
                default: // error/default
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}