package com.iitr.gl.springmvc.studentmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.iitr.gl.springmvc.studentmgmt.entity.Student;
import com.iitr.gl.springmvc.studentmgmt.service.StudentMgmtService;

@Controller
public class StudentMgmtController {
	
	private StudentMgmtService studentMgmtService;

	@Autowired(required=true)
	public StudentMgmtController(@Qualifier("studentMgmtService") StudentMgmtService studentMgmtService) {
		super();
		this.studentMgmtService = studentMgmtService;
	}
	
    @GetMapping("/students")
	public String listStudents(Model model) {
    	
    	System.out.println("--------------------> " + studentMgmtService);
    	
    	model.addAttribute("student", new Student());
		model.addAttribute("studentlist", this.studentMgmtService.listStudents());
		
		System.out.println("<-------------------- " + model.toString());
		
		return "studentslist";
    }
}
