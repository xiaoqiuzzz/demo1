package com.demo1.dao;

import com.demo1.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.demo1.entity.Student;

import java.util.List;

/**
 * 提供访问底层数据库的接口...
 */
@Mapper
public interface StudentMapper {

    List<Student> findAllStudents();
    Student findStudentById(Long studentId);
    int insertStudent(Student student);
    int updateStudent(@Param("studentId") Long studentId, @Param("email") String email);
    int deleteStudent(Long studentId);
    int deleteAll();
    int truncateAll();
}
