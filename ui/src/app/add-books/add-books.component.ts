import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {

  booksForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.booksForm = this.formbuilder.group({
      title: ['', Validators.required],
      author: ['', Validators.required],
      isbn: ['', Validators.required],
      publicationDate: [, Validators.required],
      publisher: ['', Validators.required],
      copies: [Validators.required],
      category: ['', Validators.required],
      genre: ['', Validators.required],
      subgenre: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  saveBook(){
    const bookData = this.booksForm.value;
    this.http.post("http://localhost:8080/books/saveBook", bookData)
        .subscribe(response => {
          console.log("Book saved to DB", response);
          this.router.navigateByUrl('/book')
        },
        error => {
          console.error("Error occured in Book Save", error);
        });

  }
}
