import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

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
  

  constructor(private service:HttpService,private router:Router) { }

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
  onAddInvoice(){
    this.router.navigate(['/createinvoice']);
  }
  onUpdate(){
    if(this.isSelect){
      //update a record
      this.router.navigate(['/updatecustomer']);
      
    }else{
      alert("Please Select a Record to Update");
    }
    
    
}
onEdit(item:any){
  // console.log(item);
  this.isSelect=true;
  //this.cusobj=item;
}

}
