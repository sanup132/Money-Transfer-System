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

  constructor(private service: UserService) { }

  addPayee(): void {
    const data = {
      name: this.payee.name,
      accountNumber:this.payee.accountNumber,
    };

    this.service.addPayee(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newPayee(): void {
    this.submitted = false;
    this.payee = {
      name: '',
      accountNumber: ''
    };
  }

}
