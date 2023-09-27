import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  employeeId:string|null='';

  constructor(private router:Router) { }

  ngOnInit(): void {
    this.employeeId=sessionStorage.getItem("employeeId");
  }
  onLogout(){
    sessionStorage.removeItem("employeeId");
    sessionStorage.clear();
    this.router.navigate(['/login']);
}

}
