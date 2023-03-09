import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPayeeComponent } from './components/add-payee/add-payee.component';
import { CreateTransactionComponent } from './components/create-transaction/create-transaction.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { TransactionRecordsComponent } from './components/transaction-records/transaction-records.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorials', pathMatch: 'full' },
  { path: 'registration', component:RegistrationComponent, pathMatch: 'full' },
  { path: 'login', component:LoginComponent, pathMatch: 'full' },
  { path: 'transaction-records', component:TransactionRecordsComponent, pathMatch: 'full' },
  { path: 'create-transaction', component:CreateTransactionComponent, pathMatch: 'full' },
  { path: 'add-payee', component:AddPayeeComponent, pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }