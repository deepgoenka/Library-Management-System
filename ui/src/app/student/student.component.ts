import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  title = 'Welcome to Student Page'
  
  students: any = []

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllStudents()
  }

  addStudent() {
    console.log('Button clicked')
    this.router.navigateByUrl('/add-student')
  }

  fetchAllStudents() {
    this.http.get('http://localhost:8080/students/getAllStudent')
             .subscribe(response => {
              this.students = response
              console.log('Students retrieved successfully', this.students)
             },
             error => {
              console.error('Error retrieving students', error)
             })
  }

  deleteStudent(studentID: Number) {
    const url = 'http://localhost:8080/students/deleteStudent/' + studentID;
    this.http.delete(url)
             .subscribe(response => {
              console.log('Student deleted successfully', response)
              this.fetchAllStudents()
             },
             error => {
              console.error('Error deleting student', error)
             })
  }

  updateStudent(studentID: Number) {
    this.router.navigate(['/update-student', studentID])
  }
}
