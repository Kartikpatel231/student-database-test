package com.studentdatabase.student.db.entiity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Student_Table_Demo_Java_Internship")
@Data
public class StudentEntity {
    @Column(name = "StudentId")
    @Id                             //denotes to primary key
    @GeneratedValue(strategy = GenerationType.AUTO)        //value automatic increment by jpa
    private long id;

    public StudentEntity() {
    }

    @Column(name="FullName")

    private String fullName;

    public StudentEntity(String fullName, Integer mobileNumber, String email, String password) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }
    @Column(name = "MobileName")
    private Integer mobileNumber;
    @Column(name="Email")
    private String email;
    @Column(name = "Password")
    private String password;
}
