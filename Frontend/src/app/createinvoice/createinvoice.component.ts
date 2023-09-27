import { Component, Input, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
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
  @Input() customerId:any;
  invoiceId:any;

  constructor(private service:HttpService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.customerId = params['customerId'];
      console.log('Received customerId:', this.customerId);
    });
    this.GetAllInvoice();

   

  }
  GetAllInvoice(){
    this.service.getInvoicesByCustomerId(this.customerId)
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
  onAddInvoice() {
    const customerId = this.customerId;
    console.log('Creating invoice for:', customerId);
    
    
    this.router.navigate(['/addinvoice', { customerId }]);
  }
  onAddPayment(item:any){
    const invoiceId = item.invoiceId;
    const customerId = this.customerId;
    console.log('Creating payment for:',invoiceId);
    
    
    this.router.navigate(['/transaction', { invoiceId,customerId}]);
    
  }

  

}
