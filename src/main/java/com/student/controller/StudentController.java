package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student createStudent = service.createStudent(student);

		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {

		List<Student> allStudents = service.getAllStudents();
		
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id,@RequestBody Student student) {

		Student updateStudent = service.updateStudent(id, student);
		
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> saveStudent(@PathVariable("id") Integer id) {

		service.deleteStudent(id);
		
		return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
	}

}
