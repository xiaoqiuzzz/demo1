package com.demo1.service;

import com.demo1.entity.Record;

import java.util.List;

public interface RecordService {
    List<Record> findAllRecords();
    Long findRecordId(Long studentId, Long bookId);
    Record findRecordById(Long recordId);
    List<Record> findRecordByStudentId(Long studentId);
    List<Record> findRecordByBookId(Long bookId);
    int insertRecord(Record record);
    int updateRecord(Record record);
    int deleteRecord(Long recordId);
    int deleteAll();
    int truncateAll();
}
