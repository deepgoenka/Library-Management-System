import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-publisher',
  templateUrl: './add-publisher.component.html',
  styleUrls: ['./add-publisher.component.css']
})
export class AddPublisherComponent implements OnInit {

  publisherForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.publisherForm = this.formbuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  savePublisher() {
    const publisherData = this.publisherForm.value;
    this.http.post('http://localhost:8080/publishers/savePublisher', publisherData)
             .subscribe(response => {
              console.log('Publisher saved successfully', response)
              this.router.navigateByUrl('/publisher')
             },
             error => {
              console.error('Error saving publisher', error)
             })
  }
}
