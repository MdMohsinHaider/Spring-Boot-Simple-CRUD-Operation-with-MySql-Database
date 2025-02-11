package com.mohsin.spring_boot_simple_curd_with_mysql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Repository;

import com.mohsin.spring_boot_simple_curd_with_mysql.entity.Student;
import com.mohsin.spring_boot_simple_curd_with_mysql.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDao {

    @Autowired
    private StudentRepository studentRepository;

    // Save student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    // Save multiple students
    public List<Student> saveMultipleStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // Delete student by ID
    public String deleteStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return "Student deleted successfully!";
        }
        return "Student not found!";
    }

    // Update student
    public Student updateStudent(int id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setPhone(updatedStudent.getPhone());
            return studentRepository.save(student);
        }).orElse(null);
    }
    
// JPA Query creation 🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁
    
    
    // 1. find Student by Student Id
    public Student getStudentByIdOptionalDao(int id) {
    	Optional<Student> optional = studentRepository.findById(id);
    	if (optional.isPresent()) 
    		return optional.get();
    	else return null;		
    }
    
    // 2. find Student by Student name
    public List<Student> getStudentByName(String name){
    	return studentRepository.findByName(name);
    }
    
    
    // 3. delete Student by Student name
    public int deleteStudentByName(String name){
    	return studentRepository.deleteStudentByName(name);
    }
    
    
// Paging 🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁🍁
    
    // 1. paging Acceding order
    public List<Student> getAllStudentAscByPhoneDao(String phone){
    	return studentRepository.findAll(Sort.by(Direction.ASC, phone));
    }
    
    // 2. paging Descending order
    public List<Student> getAllStudentDescByPhoneDao(String phone){
    	return studentRepository.findAll(Sort.by(Direction.DESC, phone));
    }
    
    public Page<Student> fetchStudentWithPageSizeDao(int pageNumber, int pageSize){
    	return studentRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
}

