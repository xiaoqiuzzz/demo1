package com.demo1.dao;

import com.demo1.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> findAllBooks();
    Book findBookById(Long bookId);
    int insertBook(Book book);
    int updateBook(@Param("bookId") Long bookId, @Param("bookStatus") String bookStatus);
    int deleteBook(Long bookId);
    int deleteAll();
    int truncateAll();
}
