package com.estudos.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    //Business logic
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) { //checks if email is taken with if statement
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional //(***)
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));

    if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {
        student.setName(name);
    }

    if (email != null &&
            email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)){
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(email);
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
student.setEmail(email);
        }
    }
}