package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import com.example.demo.service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return (List<Student>) studentService.getAllStudents();
	}
	
	@GetMapping("/student/{studentid}")  
	private Student getstudent(@PathVariable("studentid") int studentid)   
	{  
	return studentService.getStudentsById(studentid);  
	}  
	
	@DeleteMapping("/student/{studentid}")  
	private void deleteStudent(@PathVariable("studentid") int studentid)   
	{  
		studentService.delete(studentid);  
	}
	
	@PostMapping("/students")  
	private Student saveStudent(@RequestBody Student student)   
	{  
		return studentService.saveOrUpdate(student);  
	  
	}  
	
	@PutMapping("/student/{studentid}")  
	private Student update(@RequestBody Student student,@PathVariable("studentid") int studentid)   
	{  
		studentService.update(student, studentid);
	return student;  
	}  
	
	@GetMapping("/hostname")
	public InetAddress getHostname() throws UnknownHostException {
        
//        	String hostname = InetAddress.getLocalHost().getHostAddress();
		InetAddress hostname = java.net.InetAddress.getLocalHost();
             System.out.println("THE HOST NAME IS" + hostname);
        return hostname;
    }
}
