import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  studentForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.studentForm = this.formbuilder.group({
      id: [, Validators.required],
      name: ['', Validators.required],
      department: ['', Validators.required],
      rollNumber: [, Validators.required],
      birthDate: [, Validators.required],
      mobileNumber: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  upStudent() {
    const studentData = this.studentForm.value;
    this.http.put('http://localhost:8080/students/updateStudent', studentData)
             .subscribe(response => {
              console.log('Student updated successfully', response);
              this.router.navigateByUrl('/student');
             },
             error => {
              console.error('Error in updating Student', error);
             })
  }

}
