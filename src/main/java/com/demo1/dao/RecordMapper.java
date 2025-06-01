package com.demo1.dao;

import com.demo1.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    List<Record> findAllRecords();
    Long findRecordId(@Param("studentId") Long studentId, @Param("bookId") Long bookId);
    Record findRecordById(Long recordId);
    List<Record> findRecordByStudentId(Long studentId);
    List<Record> findRecordByBookId(Long bookId);
    int insertRecord(Record record);
    int updateRecord(Record record);
    int deleteRecord(Long recordId);
    int deleteAll();
    int truncateAll();
}
