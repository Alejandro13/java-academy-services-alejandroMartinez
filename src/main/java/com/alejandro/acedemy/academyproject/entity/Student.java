package com.alejandro.acedemy.academyproject.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id 
    @Column( name = "id" )
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "FIRST_NAME")
    private String nombre;

    @Column(name = "LAST_NAME")
    private String apellido;

    @Column(name = "BIRTH_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date nacimiento;

    @Column(name = "GENDER")
    private String genero;
    
    @Transient
    private String nombreCompleto;

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }
    
}
