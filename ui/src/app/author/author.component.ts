import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  title = 'Welcome to Author Page'
  
  authors: any = []

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAuthors()
  }

  addAuthor() {
    console.log('Button clicked')
    this.router.navigateByUrl('/add-author')
  }

  fetchAllAuthors() {
    this.http.get('http://localhost:8080/authors/getAllAuthors')
             .subscribe(response => {
              this.authors = response;
              console.log('Authors retrieved successfully', this.authors);
             },
             error => {
              console.error('Error in retrieving Authors', error);
             })
  }

  deleteAuthor(authorID: Number) {
    const url = 'http://localhost:8080/authors/deleteAuthor/' + authorID;
    this.http.delete(url)
             .subscribe(response => {
              console.log('Author deleted successfully', response)
              this.fetchAllAuthors();
             },
             error => {
              console.error('Error in deleting Author', error)
             })
  }

  updateAuthor(authorID: Number) {
    this.router.navigate(['/update-author', authorID])
  }
}
