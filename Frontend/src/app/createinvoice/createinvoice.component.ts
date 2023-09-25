import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-createinvoice',
  templateUrl: './createinvoice.component.html',
  styleUrls: ['./createinvoice.component.css']
})
export class CreateinvoiceComponent implements OnInit {

  nameSearch:string='';
  invoiceData:any[]=[];
  selected!:string;

  constructor(private service:HttpService,private router:Router) { }

  ngOnInit(): void {
    this.GetAllInvoice();
  }
  GetAllInvoice(){
    this.service.getAllInvoice()
    .subscribe((response:any)=>{
      console.log(response);
      this.invoiceData=response;
    })
  }
  onClick(item:any){
    console.log("Click over event occur...")
    this.router.navigate(['/details'])
    localStorage.setItem("invoiceId",item.invoiceId)
    console.log(item.customer.customerId)
    console.log(item.invoiceId)
    this.selected=item.amountDue;
  }

  

}
