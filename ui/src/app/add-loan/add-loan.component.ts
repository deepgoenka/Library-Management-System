import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})
export class AddLoanComponent implements OnInit {

  loanForm: FormGroup
  constructor(private formbuilder: FormBuilder, private http: HttpClient, private router: Router) { 
    this.loanForm = this.formbuilder.group({
      bookId: [, Validators.required],
      studentId: [, Validators.required],
      checkoutDate: [, Validators.required],
      dueDate: [, Validators.required],
      returnDate: [, Validators.required],
    })
  }

  ngOnInit(): void {
  }

  saveLoan() {
    const loanData = this.loanForm.value;
    this.http.post('http://localhost:8080/loans/saveLoan', loanData)
             .subscribe(response => {
              console.log('Loan saved successfully', response)
              this.router.navigateByUrl('/loan')
             },
             error => {
              console.error('Error in saving loan', error)
             })
  }

}
