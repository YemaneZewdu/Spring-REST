package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students; 
	
	// define @PostConstruct to load the Student data ... only once
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		
		students.add(new Student("Yem", "Zew"));
		students.add(new Student("Sam", "Zew"));
		students.add(new Student("Ank", "Zew"));
	}
	
	
	// define endpoint for "/students" to return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return students;
	}
	
	// define endpoint for "/students/{studentID}" to return student at index
	// the path variable {studentId} must match with the method param 
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId against the list size
		
		if ((studentId >= students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found> " + studentId);
		}
		return students.get(studentId);
	}
	
		// Exception handler methods moved to the GlobalExceptionHandler class
	
	
}
