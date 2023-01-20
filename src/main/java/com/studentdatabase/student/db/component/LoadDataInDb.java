package com.studentdatabase.student.db.component;

import com.studentdatabase.student.db.entiity.StudentEntity;
import com.studentdatabase.student.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class LoadDataInDb implements CommandLineRunner{
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.count() > 0) {
            return;
        }
        StudentEntity studentEntity1=new StudentEntity("kartik",1234123122,"Kartik@gmail","12344@355");
        StudentEntity studentEntity2=new StudentEntity("kartik1",2134123122,"Kartik1@gmail","1234$%455");
        StudentEntity studentEntity3=new StudentEntity("kartik2",1511123122,"Karti3@gmail","12344#@#$55");
        StudentEntity studentEntity4=new StudentEntity("kartik3",1134123122,"Kartik4@gmail","1#$@234455");
        StudentEntity studentEntity5=new StudentEntity("kartik4",1214123122,"Kartik5@gmail","123$@#$4455");
        StudentEntity studentEntity6=new StudentEntity("kartik5",1131121122,"Kartik6@gmail","1@#$@234455");
        StudentEntity studentEntity7=new StudentEntity("kartik6",1231121122,"Kartik7@gmail","12344#$@55");
        StudentEntity studentEntity8=new StudentEntity("kartik7",1211123122,"Kartik8@gmail","123$#@4455");
        List<StudentEntity> studentEntity= Arrays.asList(studentEntity1,studentEntity2,studentEntity3,studentEntity4,studentEntity5,studentEntity6,studentEntity7,studentEntity8);


            studentRepository.saveAll(studentEntity);
    }
}
