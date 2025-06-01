package com.demo1.service.impl;

import com.demo1.entity.Student;
import com.demo1.dao.StudentMapper;
import com.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 处理Student相关的业务逻辑，调用数据库接口进行查询
 */
@Service
//@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }

    @Override
    public Student findStudentById(Long studentId) {
        return studentMapper.findStudentById(studentId);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int updateStudent(Long studentId, String email) {
        return studentMapper.updateStudent(studentId, email);
    }

    @Override
    public int deleteStudent(Long studentId) {
        return studentMapper.deleteStudent(studentId);
    }

    @Override
    public int deleteAll(){
        return studentMapper.deleteAll();
    }

    @Override
    public int truncateAll() {
        return studentMapper.truncateAll();
    }
}
