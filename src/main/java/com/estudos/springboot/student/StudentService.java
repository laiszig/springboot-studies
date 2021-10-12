package com.estudos.springboot.student;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Business class that will serve as business logic for managing students
// We need to tell that the StudentService is a class that has to be instantiated, to be a Spring Bean. Using @Component
@Service //does the same as @Component, but it's more specific, telling that this is meant to be service class.
public class StudentService {

    public List<Student> getStudents() {
        return List.of(new Student(
                        1L,
                        "Mariam",
                        "mariam.jamal@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                )
        );
    }
}
