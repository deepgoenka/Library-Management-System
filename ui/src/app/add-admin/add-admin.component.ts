import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css']
})
export class AddAdminComponent implements OnInit {

  adminForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.adminForm = this.formbuilder.group({
      name: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  saveAdmin() {
    const adminData = this.adminForm.value;
    this.http.post('http://localhost:8080/admins/saveAdmin', adminData)
             .subscribe(response => {
              console.log('Admin saved successfully', response);
              this.router.navigateByUrl('/admin');
             },
             error => {
              console.error('Error in saving Admin', error);
             })
  }

}
