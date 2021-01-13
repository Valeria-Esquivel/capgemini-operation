package com.capgemini.projectoperation.persistence.crud;

import com.capgemini.projectoperation.persistence.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoCrudRepository extends CrudRepository<Alumno,Integer> {


}
