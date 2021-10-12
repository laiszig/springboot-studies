package com.estudos.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Business class that will serve as business logic for managing students
// We need to tell that the StudentService is a class that has to be instantiated, to be a Spring Bean. Using @Component
@Service //does the same as @Component, but it's more specific, telling that this is meant to be service class.
public class StudentService {

    //instance of the repository >>> Generate constructor >>>> annotate with dependency injection @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
