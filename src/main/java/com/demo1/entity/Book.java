package com.demo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "books")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_status")
    private String bookStatus;

    public Book(String bookName, String bookStatus){
        this.bookName = bookName;
        this.bookStatus = bookStatus;
    }
}
