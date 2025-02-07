package com.mohsin.spring_boot_simple_curd_with_mysql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students") 
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String email;
    private long phone;
}
