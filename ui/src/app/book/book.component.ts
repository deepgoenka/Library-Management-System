import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  title = 'Welcome to Book Page'

  books: any = []
  
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllBooks();
  }

  addBooks() {
    console.log("Button clicked")
    this.router.navigateByUrl('/add-books')
  }

  fetchAllBooks() {
    this.http.get("http://localhost:8080/books/getAllBooks")
             .subscribe(response => {
              this.books = response;
              console.log('Books retrieved successfully', this.books);
             },
             error => {
              console.error('Error retrieving books', error);
             });
  }

  deleteBooks(bookID: Number) {
    const url = 'http://localhost:8080/books/delete/' + bookID;
    this.http.delete(url)
             .subscribe(response => {
              console.log('Book deleted successfully', response)
              this.fetchAllBooks()
             },
             error => {
              console.error('Error in deleting book', error)
             })
  }

  updateBooks(bookID: Number) {
    this.router.navigate(['/update-book', bookID])
  }
}
