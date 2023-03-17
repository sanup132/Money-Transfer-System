import { Component } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  user: User = {
    name: '',
    userId: '',
    accountNumber: '',
    password: '',
    balance: 0,
  };
  submitted = false;
  accountNumberIsValidCheck = false;
  accountNumberIsValidText = '';
  balanceIsValidCheck = false;
  balanceIsValidText = '';

  constructor(private service: UserService) { }

  registerUser(): void {

    if (this.user.name != '' && this.user.userId != '' && this.user.accountNumber != '' && this.user.password != '' && this.user.balance != 0) {
      const data = {
        name: this.user.name,
        userId: this.user.userId,
        accountNumber: this.user.accountNumber,
        password: this.user.password,
        balance: this.user.balance
      };

      this.service.register(data)
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

  newUser(): void {
    this.submitted = false;
    this.user = {
      name: '',
      userId: '',
      accountNumber: '',
      password: '',
      balance: 0
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

  balanceValidation(event: any) {
    if (event != null) {
      if (event > 0) {
        this.balanceIsValidCheck = true;
      }
      else {
        this.balanceIsValidCheck = false;
        this.balanceIsValidText = 'Balance cannot be negative'
      }
    }
  }

}