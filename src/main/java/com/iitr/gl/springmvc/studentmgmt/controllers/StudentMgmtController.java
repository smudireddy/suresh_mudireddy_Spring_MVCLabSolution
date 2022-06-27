package com.iitr.gl.springmvc.studentmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dineshonjava.bean.EmployeeBean;
import com.dineshonjava.model.Employee;
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
    	
    	model.addAttribute("student", new Student());
		model.addAttribute("studentlist", this.studentMgmtService.listStudents());
		return "studentslist";
    }
    
	@GetMapping("/showFormForRegister")
	public String showFormForRegister(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("mode", "Register");
		return "student-form";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("studentId") int studentId, Model model) {
		
		Student student = studentMgmtService.getStudentById(studentId);
		model.addAttribute("student", student);
		model.addAttribute("mode", "Update");
		return "student-form";
	}
	
	@PostMapping("/registerStudent")
	public String registerStudent(@RequestParam("studentId") int studentId, 
			@RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName, 
			@RequestParam("course") String course,
			@RequestParam("country") String country, 
			Model model) {
		
		Student student = null;
		if (studentId == 0) {
			student = new Student(firstName, lastName, course, country);
			studentMgmtService.addStudent(student);
			
		} else {
			student = studentMgmtService.getStudentById(studentId);
			if(student != null) {
				
				student.setCountry(country);
				student.setCourse(course);
				student.setFirstName(firstName);
				student.setLastName(lastName);
				studentMgmtService.updateStudent(student);
			}
		}
		
		model.addAttribute("student", student);
		model.addAttribute("mode", "Update");
		return "student-form";
	}
	
	@GetMapping("/unregister")
	public String unregister(@RequestParam("studentId") int studentId, Model model) {
		
		System.out.println("--------->" + " " + studentId + " " +  model);
		
		Student student = studentMgmtService.getStudentById(studentId);
		if (student != null) {
			
			System.out.println("<--------->");
			
			studentMgmtService.removeStudentById(studentId);
			model.addAttribute("studentlist", this.studentMgmtService.listStudents());
			return "studentslist";
		}
		return null;
	}
	
}
