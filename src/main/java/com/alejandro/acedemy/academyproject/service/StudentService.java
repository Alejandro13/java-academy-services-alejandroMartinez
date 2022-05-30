package com.alejandro.acedemy.academyproject.service;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.alejandro.acedemy.academyproject.entity.Student;
import com.alejandro.acedemy.academyproject.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository repository;

    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    public Optional<Student> getStudentById( Integer studentId ){
        
        return repository.findById(studentId); //select id from table;		

	}

    public Student saveStudent(Student newStudent){       
       
        return repository.save(newStudent);
    }

  
    
}
