package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	

	// define endpoint for "/students" to return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Yem", "Zew"));
		students.add(new Student("Sam", "Zew"));
		students.add(new Student("Ank", "Zew"));
		
		return students;
	}
}