package com.mohsin.spring_boot_simple_curd_with_mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mohsin.spring_boot_simple_curd_with_mysql.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByName(String name);
	
	@Query(value = "DELETE Student s WHERE s.name=?1")
	@Modifying
	@Transactional
	int deleteStudentByName(String name);
}
