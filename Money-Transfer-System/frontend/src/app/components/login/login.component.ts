import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  userForm = new FormGroup({
    userId: new FormControl(),
    password: new FormControl()
  });

  constructor(private service: UserService) { }

  loginUser(): void {
    if ( this.userForm.value.userId != '' &&  this.userForm.value.password != '' ) {
     

    this.service.login(this.userForm.value.userId, this.userForm.value.password)
      .subscribe({
        next: (res) => {
          console.log(res);
        },
        error: (e) => console.error(e)
      });
      alert("login sucessfully")
    }
    else {
      alert("Invalid or incomplete data")
    }
   
  }
  
  }



