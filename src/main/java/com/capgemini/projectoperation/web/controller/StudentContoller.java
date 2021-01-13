package com.capgemini.projectoperation.web.controller;

import com.capgemini.projectoperation.domain.service.Student;
import com.capgemini.projectoperation.domain.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentContoller {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    @ApiOperation("Get All Students")
    @ApiResponse(code = 200,message = "ok")
    public ResponseEntity<List<Student>> getAll(){

        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }


    @ApiOperation("shearch a product with an Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok"),
            @ApiResponse(code = 404,message = "Student Not Found"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@ApiParam(value = "the id of the student",required = true,example = "1") @PathVariable("id") int studentId){
        return studentService.getStudent(studentId)
                .map(student -> new ResponseEntity<>(student,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Save Student")
    @ApiResponse(code = 201,message = "created")
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }



}
