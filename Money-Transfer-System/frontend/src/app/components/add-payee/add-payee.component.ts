

import { Component } from '@angular/core';
import { Payee } from 'src/app/models/payee';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-payee',
  templateUrl: './add-payee.component.html',
  styleUrls: ['./add-payee.component.css']
})
export class AddPayeeComponent {
  payee: Payee = {
    name: '',
    accountNumber: ''
  };
  submitted = false;
  accountNumberIsValidCheck = false;
  accountNumberIsValidText = '';

  constructor(private service: UserService) { }

  addPayee(): void {
    if (this.payee.name != '' && this.payee.accountNumber != '') {
      const data = {
        name: this.payee.name,
        accountNumber: this.payee.accountNumber,
      };

      this.service.addPayee(data)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.submitted = true;
          },
          error: (e) => console.error(e)
        });
      alert("Data submitted successfully")
    }
    else {
      alert("Invalid or incomplete data")
    }
  }

  newPayee(): void {
    this.submitted = false;
    this.payee = {
      name: '',
      accountNumber: ''
    };
  }

  accountNumberValidation(event: any) {
    if (event != null) {
      var len = event.toString().length;
      if (len == 12) {
        this.accountNumberIsValidCheck = true;
      }
      else {
        this.accountNumberIsValidCheck = false;
        this.accountNumberIsValidText = "Account Number should contain 12 digits"
      }
    }
  }

}