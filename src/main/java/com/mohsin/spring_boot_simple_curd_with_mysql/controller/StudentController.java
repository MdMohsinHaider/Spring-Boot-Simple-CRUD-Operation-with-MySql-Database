package com.mohsin.spring_boot_simple_curd_with_mysql.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohsin.spring_boot_simple_curd_with_mysql.entity.Student;

@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>();
	
	@RequestMapping(value = "/getStudentDob", method = RequestMethod.GET)
	public String getStudentDob() {
		return LocalDate.parse("1997-10-10")+" ";
	}
	
	
	@PostMapping(value = "/addition/{a}/{b}")
	public Integer additionTwoNumber(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		return a+b;
	}
	
	@PostMapping(value = "/saveStudent")
	public Student saveStudentController(@RequestBody Student student){
		System.out.println(student);
		return student;
	}
	
	@PostMapping(value = "/saveMultipleStudent")
	public List<Student> saveStudentsController(@RequestBody List<Student> students) {
		this.students.addAll(students);
		
		for (Student student : students) {
			System.out.println(student);
		}
		return students;
	}
	
	
	@GetMapping(value = "/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable(name = "id") Integer id) {
		for (Student student : students) {
			int idStudent = student.getId();
			if (idStudent == id) {
				System.out.println(student);
				students.remove(student);
				return "delete";
			}
		}
		return "Something went wrong";
	}
	
	
	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudentController(){
		return students;
	}
}
