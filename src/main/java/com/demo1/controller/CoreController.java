package com.demo1.controller;

import com.demo1.ApiResponse;
import com.demo1.entity.Record;
import com.demo1.service.impl.CoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
public class CoreController {
    @Autowired
    private CoreServiceImpl coreServiceImpl;

    @PostMapping("/borrow")
    public Long borrow(@RequestParam("studentId") Long StudentId, @RequestParam("bookId") Long bookId ){
        return coreServiceImpl.borrow(StudentId, bookId);
    }

    @PostMapping("/giveback")
    public Long giveback(@RequestParam("studentId") Long StudentId, @RequestParam("bookId") Long bookId ){
        return coreServiceImpl.giveback(StudentId, bookId);
    }

    @GetMapping("/findByStudentId")
    public ApiResponse<List<Record>> findRecordsByStudentId(@RequestParam Long studentId) {
        List<Record> list = coreServiceImpl.findRecordsByStudentId(studentId);
        return ApiResponse.success("found "+list.size()+" records", list);
    }

    @GetMapping("/findByBookId")
    public ApiResponse<List<Record>> findRecordsByBookId(@RequestParam Long bookId) {
        List<Record> list = coreServiceImpl.findRecordsByBookId(bookId);
        return ApiResponse.success("found "+list.size()+" records", list);
    }

}
