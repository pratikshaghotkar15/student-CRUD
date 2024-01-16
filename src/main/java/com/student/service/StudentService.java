package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student updateStudent(Integer id,Student student);
	
	public void deleteStudent(Integer id);

}
