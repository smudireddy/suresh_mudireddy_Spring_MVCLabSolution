package com.iitr.gl.springmvc.studentmgmt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iitr.gl.springmvc.studentmgmt.entity.Student;

@Repository
public interface StudentDao {

	public List<Student> listStudents();

	public Student getStudentById(int studentId);

	public void addStudent(Student theStudent);

	public void updateStudent(Student theStudent);

	public void removeStudentById(int studentId);
}
