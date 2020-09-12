import { Component, OnInit } from '@angular/core'
import { Booking } from '../user/Booking'
import { AdminService } from './admin.service';
import { AssignWasher } from './assignwasher';
import { WasherProfile } from './washer';
import { Router } from '@angular/router';

@Component({
    templateUrl: './pendingorders.component.html',
    styleUrls: ['./pendingorders.component.css','./admin.component.css']

})
export class PendingOrdersComponent implements OnInit{
    
    assignwasher:AssignWasher;
    orders:Booking[];
    totalWashers:WasherProfile[];
    constructor(private service:AdminService,private routes:Router){}
    ngOnInit(){
        this.assignwasher= new AssignWasher();
        this.service.allPendingOrders().subscribe((data)=>{
            this.orders=data;
            console.log(data);
        });
        this.service.totalWashers().subscribe((data)=>{
            this.totalWashers=data;
            console.log(data);
        });
    }
    assignToWasher(){
        const fd= new FormData();
        fd.append("orderNo",this.assignwasher.orderNo);
        fd.append("washerEmail",this.assignwasher.washerEmail);
        this.service.assignNewWasher(fd).subscribe((data)=>{
            console.log(data);
            alert("Order is Assigned to Washer");
            this.routes.navigate(['/orders']);
        });
    }
   
}