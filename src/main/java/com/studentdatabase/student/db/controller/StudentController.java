package com.studentdatabase.student.db.controller;

import java.util.List;
import java.util.Optional;
import com.studentdatabase.student.db.entiity.StudentEntity;
import com.studentdatabase.student.db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable) {
        return new ResponseEntity<Page<StudentEntity>>(studentService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<StudentEntity> userOpt = studentService.findById(id);

        if (userOpt.isPresent()) {
            return new ResponseEntity<StudentEntity>(userOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody StudentEntity studentEntity) {
        studentService.add(studentEntity);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<StudentEntity> optUser = studentService.delete(id);

        if (optUser.isPresent()) {
            return new ResponseEntity<StudentEntity>(optUser.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody StudentEntity studentEntity) {
        Optional<StudentEntity> optUser = studentService.update(studentEntity);

        if (optUser.isPresent()) {
            return new ResponseEntity<StudentEntity>(optUser.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
