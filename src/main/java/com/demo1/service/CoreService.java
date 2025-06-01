package com.demo1.service;

import java.util.List;
import com.demo1.entity.Record;


public interface CoreService {
    Long borrow(Long studentId, Long bookId);
    Long giveback(Long studentId, Long bookId);
    List<Record> findRecordsByStudentId(Long studentId);
    List<Record> findRecordsByBookId(Long studentId);
}
