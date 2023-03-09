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
    password:'',
    balance: 0,
  };
  submitted = false;

  constructor(private service: UserService) { }

  registerUser(): void {
    const data = {
      name: this.user.name,
      userId: this.user.userId,
      accountNumber:this.user.accountNumber,
      password:this.user.password,
      balance:this.user.balance
    };

    this.service.register(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newUser(): void {
    this.submitted = false;
    this.user = {
      name: '',
      userId: '',
      accountNumber: '',
      password:'',
      balance: 0
    };
  }

}
