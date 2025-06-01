package com.demo1.service.impl;

import com.demo1.entity.Book;
import com.demo1.entity.Student;
import com.demo1.service.BookService;
import com.demo1.service.CoreService;
import com.demo1.service.DataMockService;
import com.demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataMockServiceImpl implements DataMockService {
    static int bookId;
    static int studentId;

    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CoreService coreService;

    @Override
    public int insertBooksBatch() {
        long start = System.currentTimeMillis();
        for(long i = 1; i < 10000; i++) {
            Book book = new Book(i, "book" + i, "0");
            bookService.insertBook(book);
        }
        long end = System.currentTimeMillis();
        return (int)(end - start);
    }

    @Override
    public int insertStudentsBatch() {
        long start = System.currentTimeMillis();
        for(long i = 1; i < 10000; i++) {
            Student student = new Student(i, "stu" + i, i+"@163.com");
            studentService.insertStudent(student);
        }
        long end = System.currentTimeMillis();
        return (int)(end - start);
    }

    @Override
    public int simulateBorrowing() {
        long start = System.currentTimeMillis();
        for(long i = 1; i < 500; i++){
            long[] iarr = {i};
            new Thread(()-> {
                for (int j = 1; j < 10; j++) {
                    coreService.borrow(iarr[0], 5000 - (iarr[0] - 1) * 10 - j);
                }
            }).start();
        }
        long end = System.currentTimeMillis();
        return (int)(end - start);
    }

    @Override
    public int simulateGivingback() {
        long start = System.currentTimeMillis();
        for(long i = 1; i < 5000; i++){
            coreService.giveback(i, 5000 - i);
        }
        long end = System.currentTimeMillis();
        return (int)(end - start);
    }
}
