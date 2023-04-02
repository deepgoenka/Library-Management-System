package com.xfactor.openlibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByDepartment(String department);
    List<Student> findByBirthDate(String birthDate);
    List<Student> findByRollNumber(String rollNumber);
    List<Student> findByMobileNumber(String mobileNumber);
    
}
