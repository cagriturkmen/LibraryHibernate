package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Book;

import jakarta.persistence.TypedQuery;

public class BookDao implements IRepository<Book>{

	@Override
	public void create(Book entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Book data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Book data.");
		}finally {
			session.close();
		}				
	}

	@Override
	public void update(long id, Book entity) {
		Session session = null;
		try {
			Book updateUser = find(id);
			updateUser.setTitle(entity.getTitle());
			updateUser.setActiveStudent(entity.getActiveStudent());
			updateUser.setBookDetail(entity.getBookDetail());
		//	updateUser.setUserDetail(entity.getUserDetail());
			
			
			session = databaseConnection();
			session.getTransaction().begin();
			session.merge(updateUser);
			session.getTransaction().commit();
			System.out.println("Successfully updated Book.");
		} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Some problem occured while UPDATING Book data.");
		}finally {
			session.close();
		}			
	}

	@Override
	public void delete(long id) {
Session session= null;
		
		try {
			Book deleteAddress = find(id);
			if(deleteAddress != null) {
				session = databaseConnection();
				session.getTransaction().begin();
				session.remove(deleteAddress);
				session.getTransaction().commit();
				
				System.out.println("Successfully deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while DELETING Book data.");		
		} finally {
			session.close();
		}				
	}

	@Override
	public List<Book> listAll() {
		Session session = databaseConnection();
		//hibernate query language
		String hql = "select adr from Book as adr";
		
		TypedQuery<Book> typedQuery = session.createQuery(hql,Book.class);
		List<Book> userList = typedQuery.getResultList();
		
		return userList;
	}

	@Override
	public Book find(long id) {
		Book user = null;
		Session session = databaseConnection();
		
		try {
			user = session.find(Book.class, id);
			
			if(user != null) {
				System.out.println("Found Book : " + user);
			}else {
				System.out.println("Book not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND Book data.");
		}finally {
			session.close();
		}
		return user;
	}

}
