import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

 baseUrl:string='http://localhost:8085/users/';
 // baseUrl:string=environment.baseUrl;
 baseUrl2:string='http://localhost:8085/customer/';
 url:string='http://localhost:8085/customer';
 invoiceurl:string='http://localhost:8085/invoices/createinvoice/';
 allinvoice:string='http://localhost:8085/invoices/';
 invoiceTransaction:string='http://localhost:8085/transaction/gettransactionbyinvoice';

  constructor(private http:HttpClient) { }

  login(obj:any){
    return (this.http.post(`${this.baseUrl}login`,obj));
  }
  getAllRecord(){
    return (this.http.get(`${this.baseUrl2}getcustomer`));
  }
  getAllInvoice(){
    return (this.http.get(`${this.allinvoice}getallinvoice`));
  }
  getAllInvoiceById(){
    return (this.http.get(`${this.allinvoice}getinvoice/${localStorage.getItem("invoiceId")}`));
  }
  getTransactionByInvoiceId(){
    return (this.http.get(`${this.invoiceTransaction}/${localStorage.getItem("invoiceId")}`));
  }
  


postData(obj:any){
    return (this.http.post(this.url,obj));
}
postInvoice(obj:any){
  return (this.http.post(this.invoiceurl,obj));
}

}