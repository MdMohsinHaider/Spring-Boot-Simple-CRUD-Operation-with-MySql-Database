package com.mohsin.spring_boot_simple_curd_with_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mohsin.spring_boot_simple_curd_with_mysql.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
