package com.iitr.gl.springmvc.studentmgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    /*
    @PostMapping(value = "/save")
	public ModelAndView saveStudent(@Model model, Student student) {
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}
	*/
}
