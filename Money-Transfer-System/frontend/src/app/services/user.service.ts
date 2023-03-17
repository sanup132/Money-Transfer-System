import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  register(data: any): Observable<any> {
    return this.http.post("http://localhost:5555/bank/users", data);
  }

  login(userId: String, passowrd: String): Observable<any> {
    return this.http.get(`http://localhost:5555/bank/users/user/${userId}/password/${passowrd}`);
  }

  getUserById(userId: String): Observable<any> {
    return this.http.get(`http://localhost:5555/bank/users/user/${userId}`);
  }

  addPayee(data: any): Observable<any> {
    return this.http.post("http://localhost:5555/bank/payee", data);
  }
  
  getUserPayees(userId: String): Observable<any> {
    return this.http.get(`http://localhost:5555/bank/users/${userId}/payees`);
  }

  getPayeeById(payeeId: String): Observable<any> {
    return this.http.get(`http://localhost:5555/bank/payees/payee/${payeeId}`);
  }

  createTransaction(userId: any, data: any): Observable<any> {
    return this.http.post("http://localhost:5555/bank/transaction", data);
  }

}
