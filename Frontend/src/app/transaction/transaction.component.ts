import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router,ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  invoiceId:any;
  customerId:any;
  amountDue:any;
  dueDate:any;
  currentDateTime: string|null;

  constructor(private service:HttpService,private router:Router,private route: ActivatedRoute,private datePipe: DatePipe) {
    
    const currentDateTime = new Date();
    this.currentDateTime = this.datePipe.transform(currentDateTime, 'yyyy-MM-dd HH:mm:ss');
    console.log(this.currentDateTime);
   }


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.invoiceId = params['invoiceId'];
      this.customerId = params['customerId'];
      console.log('Received invoiceId:', this.invoiceId,this.customerId);
      
      
    });

    this.service.getInvoiceById(this.invoiceId)
    .subscribe((response:any)=>{
      this.amountDue=response[0].amountDue;
      let el=document.getElementById("amount");
      el?.setAttribute('value',this.amountDue);
      this.dueDate=response[0].dueDate;

      if(this.currentDateTime!==null){
        let el=document.getElementById("duedate");
         el?.setAttribute('value',this.currentDateTime);
        }
      if(this.currentDateTime!==null){
      if(this.dueDate>this.currentDateTime){
        this.amountDue=this.amountDue-((this.amountDue*5)/100);
        let el=document.getElementById("amount");
      el?.setAttribute('value',this.amountDue);
       el=document.getElementById("discount");
      el?.setAttribute('value','yes');
      }
      else{
        el=document.getElementById("discount");
      el?.setAttribute('value','no');
      }
    }
    })


  }
  addTransaction(date:any,amount:any,paymentMethod:any,discount:any){
    let obj= {
       
      "customer": {
          "customerId": this.customerId
      },
      "invoice": {
          "invoiceId": this.invoiceId
          
      },
      "date": date,
      "amount": amount,
      "paymentMethod": paymentMethod,
      "discount": discount
  }
    this.service.postTransaction(obj).subscribe((response:any)=>{
      console.log(response)
    })
    this.service.updatePayment(this.invoiceId, 'Paid').subscribe((paymentResponse: any) => {
      console.log('Payment status updated:', paymentResponse);
    });
    this.router.navigate(['/home']);

  }

}
