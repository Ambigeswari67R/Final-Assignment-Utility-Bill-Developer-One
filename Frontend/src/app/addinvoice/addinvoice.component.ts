import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addinvoice',
  templateUrl: './addinvoice.component.html',
  styleUrls: ['./addinvoice.component.css']
})
export class AddinvoiceComponent implements OnInit {
  
customerId:any;

constructor(private service: HttpService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.customerId = params['customerId'];
      console.log('Received customerId:', this.customerId);
      
      
    });
  }

  
  





  addCustomerinvoice(unitConsumed:any,billDueDate:any){
    let invoiceobj=
  {
    "customer": {
            "customerId": this.customerId      
        },
        "amountDue": unitConsumed*500,
        "dueDate": billDueDate
    }
    this.service.postInvoice(invoiceobj).subscribe((response:any)=>{
      if(response.result==='OK'){
        alert("Invoice updated successsfully")
        this.router.navigate(['/createinvoice']);
      }
      else{
        alert("Failed to add")
      }
    
    })

  }

}
