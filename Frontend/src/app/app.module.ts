import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { CreateinvoiceComponent } from './createinvoice/createinvoice.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { DetailsComponent } from './details/details.component';
import { AddinvoiceComponent } from './addinvoice/addinvoice.component';
import { TransactionComponent } from './transaction/transaction.component';
import { UpdatepaymentComponent } from './updatepayment/updatepayment.component';
import { DatePipe } from '@angular/common';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    AddcustomerComponent,
    CreateinvoiceComponent,
    UpdatecustomerComponent,
    NotfoundComponent,
    DetailsComponent,
    AddinvoiceComponent,
    TransactionComponent,
    UpdatepaymentComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxPaginationModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
