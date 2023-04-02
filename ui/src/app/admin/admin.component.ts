import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title = 'Welcome to Admin Page'
  admins: any = []

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAdmins()
  }

  addAdmin(){
    console.log("Button clicked")
    this.router.navigateByUrl('/add-admin')
  }

  fetchAllAdmins() {
    this.http.get('http://localhost:8080/admins/getAllAdmins')
             .subscribe(response => {
              this.admins = response;
              console.log('Admins retrieved successfully', response);
             },
             error => {
              console.error('Error in retrieving Admins', error);
             })
  }

  deleteAdmin(adminID: Number) {
    const url = 'http://localhost:8080/admins/deleteAdmin/' + adminID;
    this.http.delete(url)
             .subscribe(response => {
              console.log('Admin deleted successfully', response);
              this.fetchAllAdmins();
             },
             error => {
              console.error('Error in deleting admin', error);
             })
  }

  updateAdmin(adminID: Number) {
    this.router.navigate(['/update-admin', adminID])
  }

}
