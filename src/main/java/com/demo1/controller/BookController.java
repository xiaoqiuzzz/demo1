package com.demo1.controller;

import com.demo1.entity.Book;
import com.demo1.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/all")
    public List<Book> findAllBooks(){
        return bookServiceImpl.findAllBooks();
    }

    @GetMapping("/{bookId}")
    Book findBookById(@PathVariable Long bookId){
        return bookServiceImpl.findBookById(bookId);
    }

    @PostMapping("/insert")
    int insertBook(@RequestBody Book book){
        return bookServiceImpl.insertBook(book);
    }

    @PutMapping("/update/{bookId}")
    int updateBook(@PathVariable Long bookId, @RequestParam String bookStatus){
        return bookServiceImpl.updateBook(bookId, bookStatus);
    }

    @DeleteMapping("/delete/{bookId}")
    int deleteBook(@PathVariable Long bookId){
        return bookServiceImpl.deleteBook(bookId);
    }

    @DeleteMapping("/delete/all")
    int deleteAll(){
        return bookServiceImpl.deleteAll();
    }

    @DeleteMapping("/truncate/all")
    int truncateAll(){
        return bookServiceImpl.truncateAll();
    }
}
