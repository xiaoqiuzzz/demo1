package com.demo1.controller;

import com.demo1.ApiResponse;
import com.demo1.Response;
import com.demo1.entity.Book;
import com.demo1.entity.Student;
import com.demo1.service.DataMockService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class DataMockController {
    @Autowired
    private DataMockService dataMockService;

    @PostMapping("/insertBooks")
    public ApiResponse<Integer> insertBooksBatch() {
        int insertTime = dataMockService.insertBooksBatch();
        return ApiResponse.success("books insert time:", insertTime);
    }

    @PostMapping("/insertStudents")
    public ApiResponse<Integer> insertStudentsBatch() {
        int insertTime = dataMockService.insertStudentsBatch();
        return ApiResponse.success("students insert time:", insertTime);
    }

    @PostMapping("/borrow")
    public ApiResponse<Integer> simulateBorrowing() {
        int borrowTime = dataMockService.simulateBorrowing();
        return ApiResponse.success("borrow time:", borrowTime);
    }

    @DeleteMapping("/giveback")
    public ApiResponse<Integer> simulateGivingback() {
        int givebackTime = dataMockService.simulateGivingback();
        return ApiResponse.success("giveback time:", givebackTime);
    }

}
