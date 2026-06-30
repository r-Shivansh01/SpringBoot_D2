package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;

@RestController
public class mycontroller {
	
	private List<Student> student = new ArrayList<>();
	
	public mycontroller() {
		student.add(new Student(1, "Anand"));
		student.add(new Student(2, "Ayush"));
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		for(Student s: student) {
			if(s.getId()==id) return s;
		}
		throw new StudentNotFoundException("Student Not Found With The ID: "+ id);
	}
	
}
