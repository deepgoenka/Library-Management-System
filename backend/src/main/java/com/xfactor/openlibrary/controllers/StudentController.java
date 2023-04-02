package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Student;
import com.xfactor.openlibrary.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController {
    // ArrayList <Student> student = new ArrayList<>();

    private StudentRepository studentRepository;
    
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student stud) {
        studentRepository.save(stud);
        return stud;
    } 

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/getStudentById/{id}")
    public Student findById(@PathVariable Long id) {
        Optional<Student> optionalOfStudent = studentRepository.findById(id);
        if (optionalOfStudent.isPresent()){
            return optionalOfStudent.get();
        }
        return null;
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> findByName(@PathVariable String name){
        List<Student> listOfStudentByName = studentRepository.findAll();
        return listOfStudentByName;
    }

    @GetMapping("/getStudentByDepartment/{department}")
    public List<Student> findByDepartment(@PathVariable String department){
        List<Student> listOfStudentByDepartment = studentRepository.findByDepartment(department);
        return listOfStudentByDepartment;
    }

    @GetMapping("/getStudentByBirthDate/{birthDate}")
    public List<Student> findByBirthDate(@PathVariable String birthDate){
        List<Student> listOfStudentByBirthDate = studentRepository.findByBirthDate(birthDate);
        return listOfStudentByBirthDate;
    }

    @GetMapping("/getStudentByRollNumber/{rollNumber}")
    public List<Student> findByRollNumber(@PathVariable String rollNumber){
        List<Student> listOfStudentByRollNumber = studentRepository.findByRollNumber(rollNumber);
        return listOfStudentByRollNumber;
    }

    @GetMapping("/getStudentByMobileNumber/{mobileNumber}")
    public List<Student> findByMobileNumber(@PathVariable String mobileNumber){
        List<Student> listOfStudentByMobileNumber = studentRepository.findByMobileNumber(mobileNumber);
        return listOfStudentByMobileNumber;
    }

    @PutMapping("/updateStudent")
    public Student updateStudent (@RequestBody Student student) {
        if (student.getId() != null){
            Student updatedStudent = studentRepository.save(student);
            return updatedStudent;
        }
        return null;
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent (@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

}
