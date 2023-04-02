import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  title = 'Welcome to Publisher Page'

  publishers: any = []
  
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllPublishers()
  }

  addPublisher() {
    console.log('Button clicked')
    this.router.navigateByUrl('add-publisher')
  }

  fetchAllPublishers() {
    this.http.get('http://localhost:8080/publishers/getAllPublisher')
             .subscribe(response => {
              this.publishers = response
              console.log('Publishers retrieved successfully', this.publishers)
             },
             error => {
              console.error('Error retrieving Publishers', error)
             })
  }

  deletePublisher(publisherID: Number) {
    const url = 'http://localhost:8080/publishers/deletePublisher/' + publisherID;
    this.http.delete(url)
             .subscribe(response => {
              console.log('Publisher deleted succesfully', response)
              this.fetchAllPublishers()
             },
             error => {
              console.error('Error deleting publisher', error)
             })
  }

  updatePublisher(publisherID: Number) {
    this.router.navigate(['/update-publisher', publisherID])
  }
}
