package com.capgemini.projectoperation.domain.service;


import com.capgemini.projectoperation.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/all")
    public List<Student> getAll(){
        return studentRepository.getAll();
    }

    public Optional<Student> getStudent(int studentId){
        return studentRepository.getStudent(studentId);
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }




}
