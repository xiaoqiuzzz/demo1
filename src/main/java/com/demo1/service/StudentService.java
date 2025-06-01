package com.demo1.service;

import com.demo1.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findStudentById(Long studentId);
    int insertStudent(Student student);
    int updateStudent(Long studentId, String email);
    int deleteStudent(Long studentId);
    int deleteAll();
    int truncateAll();
}
