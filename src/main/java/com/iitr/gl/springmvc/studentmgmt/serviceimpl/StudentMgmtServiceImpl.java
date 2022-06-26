package com.iitr.gl.springmvc.studentmgmt.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iitr.gl.springmvc.studentmgmt.dao.StudentDao;
import com.iitr.gl.springmvc.studentmgmt.entity.Student;
import com.iitr.gl.springmvc.studentmgmt.service.StudentMgmtService;

@Service
public class StudentMgmtServiceImpl implements StudentMgmtService {

	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		return studentDao.listStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	@Transactional
	public void addStudent(Student theStudent) {
		studentDao.addStudent(theStudent);
	}

	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		studentDao.updateStudent(theStudent);
	}

	@Override
	@Transactional
	public void removeStudentById(int studentId) {
		studentDao.removeStudentById(studentId);
	}
}
