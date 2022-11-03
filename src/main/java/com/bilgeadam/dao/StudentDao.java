package com.bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.Student;

public class StudentDao implements IRepository<Student>{

	@Override
	public void create(Student entity) {
		Session session = null;
		try {
			session = databaseConnection();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Student data is added to Db.");
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Some problem occured while adding Student data.");
		}finally {
			session.close();
		}				
	}

	@Override
	public void update(long id, Student entity) {
		Session session = null;
		try {
			Student updateUser = find(id);
			updateUser.setUsername(entity.getUsername());
			updateUser.setPassword(entity.getPassword());
			updateUser.setBookList(entity.getBookList());
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
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student find(long id) {
		Student user = null;
		Session session = databaseConnection();
		
		try {
			user = session.find(Student.class, id);
			
			if(user != null) {
				System.out.println("Found Student : " + user);
			}else {
				System.out.println("Student not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some problem occured while FIND Student data.");
		}finally {
			session.close();
		}
		return user;
	}
	
	
	
}
