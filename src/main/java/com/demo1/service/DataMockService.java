package com.demo1.service;

public interface DataMockService {
    // int统一返回完成操作所需时间
    int insertBooksBatch();
    int insertStudentsBatch();
    int simulateBorrowing();
    int simulateGivingback();
}
