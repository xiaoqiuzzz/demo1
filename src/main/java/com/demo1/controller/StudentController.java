package com.demo1.controller;

import com.demo1.entity.Student;
import com.demo1.entity.Student;
import com.demo1.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 路由请求，调用相关服务，根据实际服务返回结果做进一步处理
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentServiceImpl;
    
    @GetMapping("/all")
    public List<Student> findAllStudents(){
        return studentServiceImpl.findAllStudents();
    }

    @GetMapping("/{studentId}")
    Student findStudentById(@PathVariable Long studentId){
        return studentServiceImpl.findStudentById(studentId);
    }

    @PostMapping("/insert")
    int insertStudent(@RequestBody Student student){
        return studentServiceImpl.insertStudent(student);
    }

    @PutMapping("/update/{studentId}")
    int updateStudent(@PathVariable Long studentId, @RequestParam String email){
        return studentServiceImpl.updateStudent(studentId, email);
    }

    @DeleteMapping("/delete/{studentId}")
    int deleteStudent(@PathVariable Long studentId){
        return studentServiceImpl.deleteStudent(studentId);
    }

    @DeleteMapping("/delete/all")
    int deleteAll(){
        return studentServiceImpl.deleteAll();
    }

    @DeleteMapping("/truncate/all")
    int truncateAll(){
        return studentServiceImpl.truncateAll();
    }
}
