package com.iitr.gl.springmvc.studentmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iitr.gl.springmvc.studentmgmt.entity.Student;

@Service
public interface StudentMgmtService {

	public List<Student> listStudents();

	public Student getStudentById(int studentId);

	public void addStudent(Student theStudent);

	public void updateStudent(Student theStudent);

	public void removeStudentById(int studentId);
}
