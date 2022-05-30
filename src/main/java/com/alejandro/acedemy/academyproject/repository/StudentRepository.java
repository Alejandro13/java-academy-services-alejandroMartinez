package com.alejandro.acedemy.academyproject.repository;

import com.alejandro.acedemy.academyproject.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
