package com.demo1.service.impl;

import com.demo1.entity.Book;
import com.demo1.dao.BookMapper;
import com.demo1.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBookById(Long bookId) {
        return bookMapper.findBookById(bookId);
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public int updateBook(Long bookId, String bookStatus) {
        return bookMapper.updateBook(bookId, bookStatus);
    }

    @Override
    public int deleteBook(Long bookId) {
        return bookMapper.deleteBook(bookId);
    }

    @Override
    public int deleteAll(){
        return bookMapper.deleteAll();
    }

    @Override
    public int truncateAll() {
        return bookMapper.truncateAll();
    }
}
