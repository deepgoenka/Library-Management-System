import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-loan',
  templateUrl: './update-loan.component.html',
  styleUrls: ['./update-loan.component.css']
})
export class UpdateLoanComponent implements OnInit {

  loanForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.loanForm = this.formbuilder.group({
      id: [, Validators.required],
      bookId: [, Validators.required],
      studentId: [, Validators.required],
      checkoutDate: [, Validators.required],
      dueDate: [, Validators.required],
      returnDate: [, Validators.required],
    })
  }

  ngOnInit(): void {
  }

  upLoan() {
    const loanData = this.loanForm.value;
    this.http.put('http://localhost:8080/loans/updateLoan', loanData)
             .subscribe(response => {
              console.log('Loan updated successfully', response);
              this.router.navigateByUrl('/loan');
             },
             error => {
              console.error('Error in updating Loan', error);
             })
  }
}
