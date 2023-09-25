import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../model/customer';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  customerobj:any=<Customer>{};
  invoiceData:any;
  invoiceTransactionData:any;
  

  constructor(private router:Router,private service:HttpService) { }

  ngOnInit(): void {
    this.GetAllInvoiceById();
    this.GetTransactionByInvoidId();
  }

  GetAllInvoiceById(){
    console.log("nav")
    this.service.getAllInvoiceById()
    .subscribe((response:any)=>{
      console.log(response);
      this.invoiceData=response;
    })
  }

  GetTransactionByInvoidId(){
    console.log("nav")
    this.service.getTransactionByInvoiceId()
    .subscribe((response:any)=>{
      console.log("transaction")
      console.log(localStorage.getItem("invoiceId"))
      console.log(response);
      this.invoiceTransactionData=response;
    })
  }

}
