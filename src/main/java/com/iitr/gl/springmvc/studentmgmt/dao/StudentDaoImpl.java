package com.iitr.gl.springmvc.studentmgmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


import com.iitr.gl.springmvc.studentmgmt.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;
	private Session session; 
	
	//private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			this.session = this.sessionFactory.openSession();
		    e.printStackTrace();
		}
	}

	public StudentDaoImpl() {
		
	}

	@Override
	public List<Student> listStudents() {
		
		List<Student> students = session.createQuery("from Student").list();

		//logger.info("Student Entities Count : -> {}", students.size());

		return students;
	}

	@Override
	public Student getStudentById(int studentId) {
		
		Student student = session.get(Student.class, studentId);
		//logger.info("Loaded student details: -> {}", student);
		return student;
	}

	@Override
	public void addStudent(Student theStudent) {
		
		System.out.println("Adding the student : " + theStudent);
		session.save(theStudent);
		//logger.info("Student saved successfully, Student Details -> {}", theStudent);
	}

	@Override
	public void updateStudent(Student theStudent) {
		
		System.out.println("Updating the student : " + theStudent);
		session.update(theStudent);
		//logger.info("Student updated successfully, Student Details -> {}", theStudent);
	}

	@Override
	public void removeStudentById(int studentId) {
		
		Student student = session.get(Student.class, studentId);
		if (student != null) {
	
			Transaction tx = session.beginTransaction();
			
			try {
				
				session.createQuery("DELETE FROM Student WHERE id = "+studentId).executeUpdate();
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
			
			//logger.info("Student entitty with id {} removed successfully", studentId);
		} else {
			//logger.info("Student entitty with id {} not available", studentId);
		}
	}
}
