package com.demo1.service.impl;

import com.demo1.dao.RecordMapper;
import com.demo1.entity.Record;
import com.demo1.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {


    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Long findRecordId(Long studentId, Long bookId){
        return recordMapper.findRecordId(studentId, bookId);
    }
    @Override
    public List<Record> findAllRecords() {
        return recordMapper.findAllRecords();
    }

    @Override
    public Record findRecordById(Long recordId) {
        return recordMapper.findRecordById(recordId);
    }

    @Override
    public List<Record> findRecordByStudentId(Long studentId) {
        return recordMapper.findRecordByStudentId(studentId);
    }

    @Override
    public List<Record> findRecordByBookId(Long bookId) {
        return recordMapper.findRecordByBookId(bookId);
    }

    @Override
    public int insertRecord(Record record) {
        return recordMapper.insertRecord(record);
    }

    @Override
    public int updateRecord(Record record) {
        return recordMapper.updateRecord(record);
    }

    @Override
    public int deleteRecord(Long recordId) {

        return recordMapper.deleteRecord(recordId);
    }

    @Override
    public int deleteAll(){
        return recordMapper.deleteAll();
    }

    @Override
    public int truncateAll() {
        return recordMapper.truncateAll();
    }
}
