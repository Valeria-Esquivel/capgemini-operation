package com.capgemini.projectoperation.domain.repository;

import com.capgemini.projectoperation.domain.service.Student;
import com.capgemini.projectoperation.persistence.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> getAll();
    Optional<Student> getStudent(int studentId);
    Student save(Student student);
    void delete(int studentId);

}
