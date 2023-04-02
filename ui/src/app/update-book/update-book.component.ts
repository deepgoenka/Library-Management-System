import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  booksForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.booksForm = this.formbuilder.group({
      id: [, Validators.required],
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

  upBook() {
    const bookData = this.booksForm.value;
    this.http.put('http://localhost:8080/books/updateBook', bookData)
             .subscribe(response => {
              console.log('Book updated successfully', response);
              this.router.navigateByUrl('/book');
             },
             error => {
              console.error('Error in updating Book', error);
             })
  }

}
