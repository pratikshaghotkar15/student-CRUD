package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		Student savedStudent = studentRepo.save(student);
		return savedStudent;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentRepo.findAll();
		return list;
	}

	@Override
	public Student updateStudent(Integer id, Student student) {
		student.setId(id);
		Student updatedStudent = studentRepo.save(student);
		return updatedStudent;
	}

	@Override
	public void deleteStudent(Integer id) {

		studentRepo.deleteById(id);
		
		
	}

}
