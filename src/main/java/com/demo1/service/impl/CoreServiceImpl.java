package com.demo1.service.impl;

import com.demo1.entity.Book;
import com.demo1.entity.Record;
import com.demo1.entity.Student;
import com.demo1.exception.BusinessException;
import com.demo1.service.CoreService;
import com.demo1.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class CoreServiceImpl implements CoreService {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @Autowired
    RecordServiceImpl recordServiceImpl;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @Override
    public Long borrow(Long studentId, Long bookId) {
        Student student = studentServiceImpl.findStudentById(studentId);
        Book book = bookServiceImpl.findBookById(bookId);
        // 检查学生Id是否存在；检查书籍是否存在/状态
        if(student == null){
            throw new BusinessException(1001, "学生不存在");
        }
        if(book == null){
            throw new BusinessException(1002, "书籍不存在");
        }
        if("1".equals(book.getBookStatus())){
            throw new BusinessException(1003, "书籍已经被借出");
        }
        // 改变书籍状态，新增一条record记录
        bookServiceImpl.updateBook(bookId, "1");
        Record record = new Record(studentId, student.getEmail(), bookId, "0");
        recordServiceImpl.insertRecord(record);
        return record.getRecordId();
    }

    @Override
    public Long giveback(Long studentId, Long bookId) {
        Student student = studentServiceImpl.findStudentById(studentId);
        Book book = bookServiceImpl.findBookById(bookId);
        // 检查学生Id、书籍存在/状态
        if(student == null){
            throw new BusinessException(1001, "学生不存在");
        }
        if(book == null){
            throw new BusinessException(1002, "书籍不存在");
        }
        if("0".equals(book.getBookStatus())){
            throw new BusinessException(1004, "书籍未曾被借出");
        }
        Long recordId = recordServiceImpl.findRecordId(studentId, bookId);

        // 改变书籍状态，减少一条record记录
        bookServiceImpl.updateBook(bookId, "0");
        recordServiceImpl.deleteRecord(recordId);
        return 1L;
    }

    @Override
    public List<Record> findRecordsByStudentId(Long studentId) {
        return recordServiceImpl.findRecordByStudentId(studentId);
    }

    @Override
    public List<Record> findRecordsByBookId(Long bookId) {
        return recordServiceImpl.findRecordByBookId(bookId);
    }

}
