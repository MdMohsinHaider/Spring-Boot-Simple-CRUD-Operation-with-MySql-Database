package com.mohsin.spring_boot_simple_curd_with_mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.mohsin.spring_boot_simple_curd_with_mysql.dao.StudentDao;
import com.mohsin.spring_boot_simple_curd_with_mysql.entity.Student;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin(value = "https//localhost:3000")
public class StudentController {

    @Autowired
    private StudentDao studentDao;
    
    @PostMapping(value = "/addition/{a}/{b}")
	public Integer additionTwoNumber(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		return a+b;
	}

    @PostMapping(value = "/saveStudent")
    public Student saveStudentController(@RequestBody Student student) {
        return studentDao.saveStudent(student);
    }
    
    @PostMapping(value = "/saveMultipleStudent")
    public List<Student> saveMultipleStudentsController(@RequestBody List<Student> students) {
        return studentDao.saveMultipleStudents(students);
    }

    @GetMapping(value = "/getAllStudents")
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @GetMapping(value = "/getStudent/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentDao.getStudentById(id);
    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentDao.deleteStudentById(id);
    }

    @PutMapping(value = "/updateStudent/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        return studentDao.updateStudent(id, updatedStudent);
    }
    
// JPA Query creation 🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁
    
    @GetMapping(value = "/getStudentByIdOptinal/{id}")
    public Student getStudentByIdOptinalController(@PathVariable int id) {
    	return studentDao.getStudentByIdOptionalDao(id);
    }
    
    @GetMapping(value = "/getStudentByName/{name}")
    public List<Student> getStudentByNameController(@PathVariable(name = "name") String name){
    	return studentDao.getStudentByName(name);
    }
    
    @DeleteMapping(value = "/deleteStudentByName/{name}")
    public int deleteStudentByNameController(@PathVariable(name = "name") String name){
    	return studentDao.deleteStudentByName(name);
    }
    
 // Paging 🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁
    
    
    @GetMapping(value = "/getAllStudentAscByPhone/{phone}")
    public List<Student> getAllStudentAscByPhoneController(@PathVariable(name = "phone") String phone){
    	return studentDao.getAllStudentAscByPhoneDao(phone);
    }
    
    
    @GetMapping(value = "/getAllStudentDescByPhone/{phone}")
    public List<Student> getAllStudentDescByPhoneController(@PathVariable(name = "phone") String phone) {
    	return studentDao.getAllStudentDescByPhoneDao(phone);
	}
    
    
    @GetMapping(value = "/fetchStudentWithPageSize/{pageNumber}/{pageSize}")
    public Page<Student> fetchStudentWithPageSizeController(@PathVariable int pageNumber, @PathVariable int pageSize){
    	return studentDao.fetchStudentWithPageSizeDao(pageNumber, pageSize);
    }
}















