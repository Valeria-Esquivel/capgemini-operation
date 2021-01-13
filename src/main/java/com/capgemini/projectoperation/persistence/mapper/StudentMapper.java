package com.capgemini.projectoperation.persistence.mapper;


import com.capgemini.projectoperation.domain.service.Student;
import com.capgemini.projectoperation.persistence.entity.Alumno;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellidos",target = "lastName"),
            @Mapping(source = "edad",target = "age"),
            @Mapping(source = "correo",target = "email"),



    })
    Student toStudent(Alumno alumno);

    List<Student> toStudents(List<Alumno> alumnos);

    @InheritInverseConfiguration

    Alumno toAlumno(Student student);
}
