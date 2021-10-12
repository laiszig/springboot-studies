package com.estudos.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//This class will contain all the resources for the API
@RestController
@RequestMapping(path = "api/v1/student") //Now we'll go to localhost:8080/api/v1/student for this
public class StudentController {

    private final StudentService studentService; //we need to tell the program that StudentService, or anything else needs to be injected into the constructor

    @Autowired //instantiates studentService and injects it into the constructor
    public StudentController(StudentService studentService) { //only this wouldn't work, because we don't have an instance of studentService
        this.studentService = studentService; //it would only work if I used new StudentService(); > But we should avoid this and use dependency injection.
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

}
