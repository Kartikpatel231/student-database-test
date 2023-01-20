package com.studentdatabase.student.db.service;

import com.studentdatabase.student.db.entiity.StudentEntity;
import com.studentdatabase.student.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Page<StudentEntity> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);    }

    @Override
    public Optional<StudentEntity> findById(Long id) {
        return studentRepository.findById(id);
    }


    @Override
    public void add(StudentEntity studentEntity) {
       studentRepository.save(studentEntity);
    }

    @Override
    public Optional<StudentEntity> update(StudentEntity studentEntity) {
           Optional<StudentEntity> userOpt = studentRepository.findById(studentEntity.getId());
        if (userOpt.isPresent()) {
            StudentEntity existingStudent = userOpt.get();

            if (studentEntity.getFullName() != null) {
                existingStudent.setFullName(studentEntity.getFullName());
            }



            if (studentEntity.getEmail() != null) {
                existingStudent.setEmail(studentEntity.getEmail());
            }

            if (studentEntity.getMobileNumber() != null) {
                existingStudent.setMobileNumber(studentEntity.getMobileNumber());
            }

            if (studentEntity.getPassword() != null) {
                existingStudent.setPassword(studentEntity.getPassword());
            }

            studentRepository.save(existingStudent);

            return Optional.of(existingStudent);
        }

        return Optional.empty();
    }

    @Override
    public Optional<StudentEntity> delete(Long id) {
        Optional<StudentEntity> studentOpt=studentRepository.findById(id);
        if (studentOpt.isPresent()) {
            studentRepository.delete(studentOpt.get());
            return studentOpt;
        }
        return Optional.empty();
    }
}
