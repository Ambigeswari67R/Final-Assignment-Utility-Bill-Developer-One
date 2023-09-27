import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  nameSearch:string='';
  customerData:any[]=[];
  isSelect:boolean=false;
  p:number=1;
  customerId: number = 0; 
  invoices: any[] = [];
  

  constructor(private service: HttpService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.GetAllRecord();
  }
  GetAllRecord(){
    this.service.getAllRecord()
    .subscribe((response:any)=>{
      console.log(response);
      this.customerData=response;
    })
  }
  onAdd(){
    this.router.navigate(['/addcustomer']);
  }
  // onAddInvoice(){
  //   this.router.navigate(['/createinvoice']);
  // }
  // onAddInvoice(customer: any) {
  //   this.customerId=customer.customerId;
  //   console.log('Creating invoice for:', customer.customerId);
  //   this.service.getInvoicesByCustomerId(this.customerId)
  //     .subscribe((data:any) => {
  //       this.invoices = data;
  //     });
      
  //   this.router.navigate(['/createinvoice']);
    
  // }
  onAddInvoice(customer: any) {
    const customerId = customer.customerId;
    console.log('Creating invoice for:', customerId);
    
    // Navigate to the 'CreateinvoiceComponent' and pass 'customerId' as a route parameter
    this.router.navigate(['/createinvoice', { customerId }]);
  }
  
    
    
}


