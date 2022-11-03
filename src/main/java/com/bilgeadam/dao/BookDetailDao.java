package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.BookDetail;

public class BookDetailDao implements IRepository<BookDetail>{

	@Override
	public void create(BookDetail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, BookDetail entity) {
		Session session = null;
		try {
			BookDetail updateUser = find(id);
			updateUser.setBookBorrowDate(entity.getBookBorrowDate());
			updateUser.setBookReturnDate(entity.getBookReturnDate());
			updateUser.setBorrowed(entity.isBorrowed());
			updateUser.setBook(entity.getBook());
		//	updateUser.setUserDetail(entity.getUserDetail());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateUser);
			session.getTransaction().commit();
			System.out.println("Successfully updated.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING User data.");
		}finally {
			session.close();
		}			
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookDetail> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDetail find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
