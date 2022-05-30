package com.alejandro.acedemy.academyproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.alejandro.acedemy.academyproject.entity.Student;
import com.alejandro.acedemy.academyproject.service.StudentService;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController

@RequestMapping(path = "/student",
                produces = "application/xml")
public class StudentController {

    @Autowired
    private StudentService service;

    
    @PostMapping("")
	public ResponseEntity<String> postStudent( @RequestBody Student newStudent){ //Lo que venga en el requestBody lo va transformar en un objeto java
		
		newStudent.setNombreCompleto(newStudent.getNombre() + newStudent.getApellido());
        //return ResponseEntity.status(HttpStatus.CREATED).body( service.saveStudent(newStudent));
        return ResponseEntity.status(HttpStatus.CREATED).body( " <student> <id> " + service.saveStudent(newStudent).getStudentId() + " </id> </student>");
        
	}

    @GetMapping("")
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return ResponseEntity.ok().body(service.findAllStudents());
    }

    @GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById( @PathVariable("studentId") Integer studentId  ){
		return service.getStudentById(studentId)
				.map( student -> ResponseEntity.ok().body(student)  )
				.orElse( ResponseEntity.status(HttpStatus.NOT_FOUND).build()  );
	}
    
   
    
}
