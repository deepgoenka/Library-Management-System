import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit {

  authorForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.authorForm = this.formbuilder.group({
      name: ['', Validators.required],
      birthDate: [, Validators.required],
      nationality: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  saveAuthor() {
    const authorData = this.authorForm.value;
    this.http.post('http://localhost:8080/authors/saveAuthor', authorData)
             .subscribe(response => {
              console.log('Author saved successfully', response);
              this.router.navigateByUrl('/author');
             },
             error => {
              console.error('Error in saving Author', error);
             })
  }
  
}
