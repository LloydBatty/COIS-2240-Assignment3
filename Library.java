// File Name : 			Library.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Wednesday, December 4, 2024
// Purpose: 			This class contains the library itself, with
//						a list of members and list of books

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    
    // Add a new MEMBER to the library
    public boolean addMember(Member member) {
    	//check member ID
    	if (findMemberById(member.getId()) == null) {
    		//no other member has that ID
    		members.add(member);
    		return true; //member added
    	}
    	else {
    		System.out.println("Sorry, a member with that ID already exists");
    		return false; //no member added
    	}
    }
    
    
    // Add a new BOOK to the library
    public boolean addBook(Book book) {
    	//check book ID
    	if (findBookById(book.getId()) == null) {
    		//no other book has that ID
    		books.add(book);
    		return true; //book added
    	} else {
    		System.out.println("Sorry, a book with that ID already exists");
    		return false; //no book added
    	}
    }
    
    
    // Find a MEMBER by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a BOOK by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of MEMBERS
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of BOOKS
    public List<Book> getBooks() {
        return books;
    }
}
