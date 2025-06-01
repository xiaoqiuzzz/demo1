package com.demo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "records")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long recordId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "email")
    private String email;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "record_status")
    private String recordStatus;

    public Record(Long studentId, String email, Long bookId, String recordStatus){
        this.studentId = studentId;
        this.email = email;
        this.bookId = bookId;
        this.recordStatus = recordStatus;
    }
}
