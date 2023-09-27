import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-addcustomer',
  templateUrl: './addcustomer.component.html',
  styleUrls: ['./addcustomer.component.css']
})
export class AddcustomerComponent implements OnInit {
  posts:any[]=[];
  showAlert: boolean = false;
  
  name:String='';
  unitConsumed:number=0;
  billDueDate:String='';
  email:String='';
  telephone:String='';
  customerId:string='';



 constructor(private router:Router,private service:HttpService) { }


  ngOnInit(): void {
  }
   addCustomer(myname:any,unitConsumed:any,billDueDate:any,email:any,telephone:any){
    let obj={
    
      name:myname,
      unitConsumed:unitConsumed,
      billDueDate:billDueDate,
      email:email,
      telephone:telephone
      
    }
    

      this.service.postData(obj).subscribe((response:any)=>{
      console.log(response)
      if(response.result==='OK'){
        this.customerId=response.custId
        localStorage.setItem("custId",response.custId)
        alert("Customer added successsfully")
        this.router.navigate(['/home']);
      }
      else{
        alert("Failed to add")
      }

    })

    console.log(this.customerId, "out func");

    let invoiceobj=
      {
        "customer": {
                "customerId": parseInt(localStorage.getItem("custId")!)+1      
            },
            "amountDue": unitConsumed*500,
            "dueDate": billDueDate
        }

    

    this.service.postInvoice(invoiceobj).subscribe((response:any)=>{

      console.log(localStorage.getItem("custId")," cust id")
      if(response.result==='OK'){
        alert("Invoice updated successsfully")
        this.router.navigate(['/home']);
      }
      else{
        alert("Failed to add")
      }

    })

    
  }


}

