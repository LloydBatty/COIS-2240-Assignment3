// File Name : 			Library.java
// Student Name: 		Lloyd Batty
// Student Number:		0817731
// Assignment:			Assignment 3
// Submission Date: 	Sunday, December 1, 2024
// Purpose: 			This class contains the library itself, with
//						a list of members and list of books

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    public void addMember(Member member) {
        members.add(member);
    }
    
    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
