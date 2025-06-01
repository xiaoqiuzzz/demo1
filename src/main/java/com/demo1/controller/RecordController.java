package com.demo1.controller;

import com.demo1.entity.Record;
import com.demo1.service.impl.RecordServiceImpl;
import com.demo1.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordServiceImpl recordServiceImpl;
    
    @GetMapping("/all")
    public List<Record> findAllRecords(){
        return recordServiceImpl.findAllRecords();
    }

    @GetMapping("/find")
    Long findRecordId(@RequestParam Long studentId, @RequestParam Long bookId){
        return recordServiceImpl.findRecordId(studentId, bookId);
    }

    @GetMapping("/find/{recordId}")
    Record findRecordById(@PathVariable Long recordId){
        return recordServiceImpl.findRecordById(recordId);
    }

    @PostMapping("/insert")
    int insertRecord(@RequestBody Record record){
        return recordServiceImpl.insertRecord(record);
    }

    // 怎么才能实现只传入必要字段进行修改，其他字段保持不变？---<if>语句
    @PutMapping("/update")
    int updateRecord(@RequestBody Record record){
        return recordServiceImpl.updateRecord(record);
    }

    @DeleteMapping("/delete/{recordId}")
    int deleteRecord(@PathVariable Long recordId){
        return recordServiceImpl.deleteRecord(recordId);
    }

    @DeleteMapping("/delete/all")
    int deleteAll(){
        return recordServiceImpl.deleteAll();
    }

    @DeleteMapping("/truncate/all")
    int truncateAll(){
        return recordServiceImpl.truncateAll();
    }

}
