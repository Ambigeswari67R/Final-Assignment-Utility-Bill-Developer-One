import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { Customer } from '../model/Customer';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-updatecustomer',
  templateUrl: './updatecustomer.component.html',
  styleUrls: ['./updatecustomer.component.css']
})
export class UpdatecustomerComponent implements OnInit {
  //@Input() parentdata:Customer=<Customer>{};
  issubmitDissabled:boolean=true;
  backendResponse:string='';

  constructor(private router:Router,private service:HttpService) { }

  ngOnInit(): void {
  }

}
