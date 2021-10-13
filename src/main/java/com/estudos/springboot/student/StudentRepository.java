package com.estudos.springboot.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//this is the default name for everything that access the db
//inside JpaRepository <> we need to specify T (type of object this repository is going to work with eg: Student) and ID (the id type eg:Long)
@Repository //tells this interface is responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Business logic
    //SELECT * FROM student WHEREE email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
