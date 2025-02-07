package com.mohsin.spring_boot_simple_curd_with_mysql.entity;

import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "students")  // Explicitly setting table name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generating ID
    private int id;
    
    private String name;
    private String email;
    private long phone;

    public Student() {
        super();
    }

    public Student(int id, String name, String email, long phone) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, id, name, phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
                && phone == other.phone;
    }
}
