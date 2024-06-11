package com.empolyee.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.empolyee.entity.Emp;
import com.empolyee.services.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model n) {
		
		List<Emp> emp=service.getAllEmp();
		n.addAttribute("emp",emp);
		return "index";
	}
	
	

	@GetMapping("/addemp")
	public String addEmployee()
	{
		return "add_emp";
	} 
	
	
	@PostMapping("/register")
	public String empResister(@ModelAttribute Emp e,HttpSession session)
	{
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "Sucessfully Added to Employee..");
		return "redirect:/";
		}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model m)
	{
		Emp e=service.getEmpbyId(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Emp e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Employee data Update sucessfully...");
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
	service.deleteEmp(id);
	session.setAttribute("msg", "Employee data delete sucessfully...");
		return "redirect:/";
		}
}
