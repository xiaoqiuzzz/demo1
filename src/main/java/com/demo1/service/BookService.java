package com.demo1.service;

import com.demo1.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Long bookId);
    int insertBook(Book book);
    int updateBook(Long bookId, String bookStatus);
    int deleteBook(Long bookId);
    int deleteAll();
    int truncateAll();
}
