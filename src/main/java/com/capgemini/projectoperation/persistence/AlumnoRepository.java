package com.capgemini.projectoperation.persistence;

import com.capgemini.projectoperation.domain.repository.StudentRepository;
import com.capgemini.projectoperation.domain.service.Student;
import com.capgemini.projectoperation.persistence.crud.AlumnoCrudRepository;
import com.capgemini.projectoperation.persistence.entity.Alumno;
import com.capgemini.projectoperation.persistence.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlumnoRepository implements StudentRepository {

    @Autowired
    private AlumnoCrudRepository alumnoCrudRepository;
    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> getAll() {
        List<Alumno> alumnosList = (List<Alumno>) alumnoCrudRepository.findAll();
        return mapper.toStudents(alumnosList);
    }

    @Override
    public Optional<Student> getStudent(int studentId) {
        return alumnoCrudRepository.findById(studentId).map(alumno -> mapper.toStudent(alumno));

    }
    @Override
    public Student save(Student student) {

        Alumno alumno = mapper.toAlumno(student);
        return mapper.toStudent(alumnoCrudRepository.save(alumno));

    }

    @Override
    public void delete(int studentId) {
        alumnoCrudRepository.deleteById(studentId);

    }


}
