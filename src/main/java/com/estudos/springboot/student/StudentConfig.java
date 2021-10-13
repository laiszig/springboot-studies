package com.estudos.springboot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

// (***)
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );
            Student alex = new Student(
                    "Alex",
                    "alex.jamal@gmail.com",
                    LocalDate.of(2004, JULY, 20)
            );

            studentRepository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}
