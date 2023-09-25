export interface Customer{
    
    customerId:number;
    name:string;
    unitConsumed:number;
    billDueDate:string;
    email:string;
    telephone:string
    user:{
        employeeId:string
        
    }
    // createddtm:number;
    // createdby:string;
    // updateddtm:number;
    // updatedby:string | null;  
  
  }