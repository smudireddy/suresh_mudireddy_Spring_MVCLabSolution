package com.iitr.gl.springmvc.studentmgmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iitr.gl.springmvc.studentmgmt.entity.Student;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;
	private Session session;

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
		return students;
	}

	@Override
	public Student getStudentById(int studentId) {

		Student student = session.get(Student.class, studentId);
		// logger.info("Loaded student details: -> {}", student);
		return student;
	}

	@Override
	public void addStudent(Student theStudent) {

		System.out.println("Adding the student : " + theStudent);
		session.save(theStudent);
	}

	@Override
	public void updateStudent(Student theStudent) {

		System.out.println("Updating the student : " + theStudent);
		session.update(theStudent);
	}

	@Override
	public void removeStudentById(int studentId) {

		Student student = session.get(Student.class, studentId);
		if (student != null) {

			Transaction tx = session.beginTransaction();
			try {

				session.createQuery("DELETE FROM Student WHERE id = " + studentId).executeUpdate();
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
		}
	}
}
