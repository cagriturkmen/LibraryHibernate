package com.bilgeadam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bilgeadam.dao.BookDao;
import com.bilgeadam.dao.StudentDao;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.Student;
import com.bilgeadam.service.LibraryService;
import com.bilgeadam.util.BAUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HibernateSession.getSessionFactory().openSession();
		Student student = new Student();
		student.setUsername("charlock");
		student.setPassword("123");
		StudentDao dao = new StudentDao();
		dao.create(student);
		
		Book book = new Book();
		book.setTitle("asd");
		BookDetail detail = new BookDetail();
		book.setBookDetail(detail);
		BookDao bookDao = new BookDao();
		bookDao.create(book);
		
		LibraryService ls = new LibraryService();
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1, "Borrow Book");
		map.put(2, "Return Book");
		int key = BAUtils.menu(map);
		
		switch (key) {
		case 1:
		 System.out.println(bookDao.listAll());	;
		 Scanner sc = new Scanner(System.in);
		 int temp = sc.nextInt();
		//bookDao.find(temp);
			ls.borrowBook(bookDao.find(temp),student);
			break;
			
		case 2:
			
			ls.returnBook(book, student);
		default:
			break;
		}
//		ls.borrowBook(book, student);	
//		ls.returnBook(book, student);
	}

}
