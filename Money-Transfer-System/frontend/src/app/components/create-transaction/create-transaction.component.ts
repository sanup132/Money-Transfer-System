import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Payee } from 'src/app/models/payee';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-transaction',
  templateUrl: './create-transaction.component.html',
  styleUrls: ['./create-transaction.component.css']
})
export class CreateTransactionComponent {

  // payees: any = [];
  payees: Payee[] = [
    { name: "Saurav", accountNumber: "123456789101"},
    { name: "Rohit", accountNumber: "123456789101"},
    { name: "Sanup", accountNumber: "123456789101"}
  ];
  userId: any;

  transactionForm = new FormGroup({
    name: new FormControl(),
    amount: new FormControl(),
    remarks: new FormControl()
  });

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    // this.getAllPayees();
  }

  // getAllPayees() {
  //   this.userService.getUserPayees(this.userId).subscribe(res => {
  //     this.payees = res;
  //   })
  // }

  createTransaction() {
    this.userService.createTransaction(this.userId, this.transactionForm.value).subscribe((res: any) => {
      console.log(res);
    })
  }

}
