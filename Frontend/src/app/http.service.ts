import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

 baseUrl:string='http://localhost:8086/users/';
 // baseUrl:string=environment.baseUrl;
 baseUrl2:string='http://localhost:8086/customer/';
 url:string='http://localhost:8086/customer';
 invoiceurl:string='http://localhost:8086/invoices/createinvoice/';
 invoice:string=environment.invoice;
 transactionUrl:string=environment.transaction;
 invoiceTransaction:string='http://localhost:8086/transaction/gettransactionbyinvoice';
 

  constructor(private http:HttpClient) { }

  login(obj:any){
    return (this.http.post(`${this.baseUrl}login`,obj));
  }
  getAllRecord(){
    return (this.http.get(`${this.baseUrl2}getcustomer`));
  }
  getAllInvoice(){
    return (this.http.get(`${this.invoice}getallinvoice`));
  }
  getAllInvoiceById(){
    return (this.http.get(`${this.invoice}getinvoice/${localStorage.getItem("invoiceId")}`));
  }

  getInvoiceById(invoiceId:any){
    return (this.http.get(`${this.invoice}getinvoice/${invoiceId}`));
  }


  getTransactionByInvoiceId(){
    return (this.http.get(`${this.invoiceTransaction}/${localStorage.getItem("invoiceId")}`));
  }
  // deleteCustomer(){
  //   return (this.http.get(`${this.baseUrl2}${localStorage.getItem("customerId")},{responseType:'text'}`));

  // }
  getInvoicesByCustomerId(customerId: number) {
    return this.http.get(`${this.invoice}${customerId}`);
  }


postData(obj:any){
    return (this.http.post(this.url,obj));
}
postInvoice(obj:any){
  return (this.http.post(this.invoiceurl,obj));
}
postTransaction(obj:any){
  return (this.http.post(`${this.transactionUrl}addtransaction`,obj));
}

updatePayment(invoiceId: number, paymentStatus: string) {
  //const url = `${this.invoice}updatepayment/${invoiceId}`; 

  const body = { paymentStatus: paymentStatus }; 
  return (this.http.put(`${this.invoice}updatepayment/${invoiceId}?paymentStatus=PAID`,body));

  
}

}