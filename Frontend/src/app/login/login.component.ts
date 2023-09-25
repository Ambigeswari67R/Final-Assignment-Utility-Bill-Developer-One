import { Component,OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit,OnDestroy {
  isShow:boolean=true;
  incorrect:string='';

  constructor(private service:HttpService,private router:Router) { }

  ngOnInit(): void {
    document.body.className='bg_background';
  }
  onShow(){
    this.isShow=!this.isShow;
  }
  onSubmit(f:NgForm){
    

    let obj={
      employeeId:f.value.employeeId,
      otp:f.value.otp
    }

    this.service.login(obj)
    .subscribe((response:any)=>{
      console.log(response.result);

      if(response.result==='Valid User'){
        // navigate to dashboard
        this.incorrect=response.result;
     sessionStorage.setItem("employeeId",response.id);
        this.router.navigate(['/home']);
      }else{
        this.incorrect=response.result;
      }

    })

  }
  ngOnDestroy(): void {
    document.body.className='';
  }

}
