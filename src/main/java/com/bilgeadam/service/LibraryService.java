package com.bilgeadam.service;

import java.time.LocalDate;

import com.bilgeadam.dao.BookDao;
import com.bilgeadam.dao.StudentDao;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.Student;

public class LibraryService {
	
	BookDao bookDao = new BookDao();
	StudentDao stuDao = new StudentDao();
	
	public void borrowBook(Book book, Student student) {
		book.getBookDetail().setBookBorrowDate(LocalDate.now());
		book.getBookDetail().setBookReturnDate(LocalDate.now().plusDays(30));
		book.getBookDetail().setBorrowed(true);
		book.setActiveStudent(student);
		
		student.getBookList().add(book);
		
		bookDao.update(book.getId(), book);
		stuDao.update(student.getId(), student);
		System.out.println(book.getTitle() + " is borrowed by" + student.getUsername());
	}
	public void returnBook(Book book, Student student) {
		book.getBookDetail().setBookBorrowDate(null);
		book.getBookDetail().setBookReturnDate(null);
		book.getBookDetail().setBorrowed(false);
		book.setActiveStudent(null);
		
		student.getBookList().remove(book);
		
		bookDao.update(book.getId(), book);
		stuDao.update(student.getId(), student);
		System.out.println(book.getTitle() + " is returned by" + student.getUsername());

	}
	
}
