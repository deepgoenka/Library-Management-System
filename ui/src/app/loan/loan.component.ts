import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  title = 'Welcome to Loan Page'
  
  loans: any = []

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllLoans()
  }

  addLoan() {
    console.log('Button clicked')
    this.router.navigateByUrl('/add-loan')
  }

  fetchAllLoans(){
    this.http.get('http://localhost:8080/loans/getAllLoans')
             .subscribe(response => {
              this.loans = response;
              console.log('Loans retrieved successfully', this.loans)
             },
             error => {
              console.error('Error retrieving loans', error)
             })
  }

  deleteLoan(loanID: Number) {
    const url = 'http://localhost:8080/loans/deleteLoan/' + loanID;
    this.http.delete(url)
             .subscribe(response => {
              console.log('Loan deleted successfully', response)
              this.fetchAllLoans()
             },
             error => {
              console.error('Error in deleting loan', error)
             })
  }

  updateLoan(loanID: Number) {
    this.router.navigate(['/update-loan', loanID])
  }
}
