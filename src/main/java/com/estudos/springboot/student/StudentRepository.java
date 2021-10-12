package com.estudos.springboot.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//this is the default name for everything that access the db
//inside JpaRepository <> we need to specify T (type of object this repository is going to work with eg: Student) and ID (the id type eg:Long)
@Repository //tells this interface is responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {
}
