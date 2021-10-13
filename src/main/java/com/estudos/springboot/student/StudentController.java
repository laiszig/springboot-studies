package com.estudos.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //create this object in the service class
    //@RequestBody: we want to take the student that comes from the client, we map it into a Student by taking it from this annotation.
    @PostMapping
    public void registerNewStudent (@RequestBody Student student) {
        studentService.addNewStudent(student);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId ) { //pathvariable helps choose how to select and delete a certain student
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}

