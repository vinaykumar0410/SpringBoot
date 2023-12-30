package com.springboot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Student;
import com.springboot.repository.StudentRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req,HttpServletResponse res) {
		int i = Integer.parseInt(req.getParameter("t1"));
		int j = Integer.parseInt(req.getParameter("t2"));
		int k = i + j;
		ModelAndView mv = new ModelAndView("second");
		mv.addObject("k",k);
		return mv;	
	}
	
	@RequestMapping("/urldata")
	public String mul(HttpServletRequest req,HttpServletResponse res, @RequestParam String name,@RequestParam int age) throws ServletException, IOException {
		System.out.println("my name is "+name+" and my age is "+age);
		req.setAttribute("name", name);
		req.setAttribute("age",age);
		RequestDispatcher rd = req.getRequestDispatcher("third");
		rd.forward(req,res);
		return "third";
	}
	
	@RequestMapping("/addstudentfromurl")
	public ModelAndView addStudentFromUrl(Student student) {
		System.out.println(student);
		ModelAndView mv = new ModelAndView("third");
		mv.addObject("student",student);
		return mv;
	}
	
	@RequestMapping("/addstudent")
	public String addStudent(Student student) {
		studentRepository.save(student);
		return "index";
	}
	
	@RequestMapping("/getstudent")
	public ModelAndView getStudent(@RequestParam int id) {
		Student student = studentRepository.findById(id).orElse(new Student());
		System.out.println(student);
		ModelAndView mv = new ModelAndView("second");
		mv.addObject("student",student);
		return mv;
	}
	
	@RequestMapping("/updatestudent")
	public ModelAndView updateStudent(@RequestParam int id,@RequestParam String name,@RequestParam int age) {
		Student student = studentRepository.findById(id).orElse(new Student());
		student.setName(name);
		student.setAge(age);
		studentRepository.save(student);
		ModelAndView mv = new ModelAndView("second");
		mv.addObject("student",student);
		return mv;
	}
	
	@RequestMapping("/deletestudent")
	public String deleteStudent(@RequestParam int id) {
		studentRepository.deleteById(id);
		return "index";
	}
}
