package com.demo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "students")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "email")
    private String email;
    
}
