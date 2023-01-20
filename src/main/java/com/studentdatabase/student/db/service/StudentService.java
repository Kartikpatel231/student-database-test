package com.studentdatabase.student.db.service;


import com.studentdatabase.student.db.entiity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Page<StudentEntity> findAll(Pageable pageable);

    public Optional<StudentEntity> findById(Long id);

    public void add(StudentEntity studentEntity);

    public Optional<StudentEntity> update(StudentEntity studentEntity);

    public Optional<StudentEntity> delete(Long id);
}
