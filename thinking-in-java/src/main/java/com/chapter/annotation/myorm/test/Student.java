package com.chapter.annotation.myorm.test;

import com.chapter.annotation.myorm.annotations.Column;
import com.chapter.annotation.myorm.annotations.Id;
import com.chapter.annotation.myorm.annotations.Table;

@Table(name = "student")
public class Student {
    @Id
    private Long id;
    @Column(name = "student_name")
    private String studentName;
}
