package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents()   
	{  
	List<Student> students = new ArrayList<Student>();  
	studentRepository.findAll().forEach(student1 -> students.add(student1));  
	return students;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Student getStudentsById(int id)   
	{  
	return studentRepository.findById((long) id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public Student saveOrUpdate(Student student)   
	{  
		return studentRepository.save(student);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		studentRepository.deleteById((long) id);  
	}  
	//updating a record  
	public void update(Student student, int studentid)   
	{  
		studentRepository.save(student);  
	}  

}
