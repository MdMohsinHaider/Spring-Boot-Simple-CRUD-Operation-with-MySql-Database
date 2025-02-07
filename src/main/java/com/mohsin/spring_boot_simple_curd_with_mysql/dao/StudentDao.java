package com.mohsin.spring_boot_simple_curd_with_mysql.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
}

