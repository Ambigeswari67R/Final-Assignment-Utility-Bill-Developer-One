import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { CreateinvoiceComponent } from './createinvoice/createinvoice.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { DetailsComponent } from './details/details.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [ {
  path:"",redirectTo:"/login",pathMatch:"full"
},
{
  path:"login",component:LoginComponent
},
{
  path:"addcustomer",component:AddcustomerComponent,canActivate: [AuthGuard]
},
{
    path:"home",component:HomeComponent,canActivate: [AuthGuard]
},
{
  path:"createinvoice",component:CreateinvoiceComponent,canActivate: [AuthGuard]
},
{
  path:"updatecustomer",component:UpdatecustomerComponent,canActivate: [AuthGuard]
},
{
  path:"details",component:DetailsComponent,canActivate: [AuthGuard]
},
{
  path:"**",component:NotfoundComponent
},
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
