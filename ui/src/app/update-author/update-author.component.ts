import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {

  authorForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.authorForm = this.formbuilder.group({
      id: [, Validators.required],
      name: ['', Validators.required],
      birthDate: [, Validators.required],
      nationality: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  upAuthor() {
    const authorData = this.authorForm.value;
    this.http.put('http://localhost:8080/authors/updateAuthor', authorData)
             .subscribe(response => {
              console.log('Author updated successfully', response);
              this.router.navigateByUrl('/author');
             },
             error => {
              console.error('Error in updating Author', error);
             })
  }
}
