package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
