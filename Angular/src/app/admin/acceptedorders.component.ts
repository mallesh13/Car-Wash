import { Component, OnInit } from '@angular/core'
import { AdminService } from './admin.service';
import { AssignWasher } from './assignwasher';
import { UserService } from '../user/user.service';
import { Booking } from '../user/Booking';

@Component({
    templateUrl: './acceptedorders.component.html',
    styleUrls: ['./acceptedorders.component.css','./admin.component.css']
})
export class AcceptedOrdersComponent implements OnInit{

    result:AssignWasher[];
    allOrders:Object[]=[];
    constructor(private adminServices:AdminService,
        private userServices:UserService){

    }
    ngOnInit(){

        this.adminServices.getAllAcceptedOrders().subscribe((data)=>{
            this.result=data;
            console.log(data);
            for (let i = 0; i <= this.result.length; ++i) {
                this.userServices.getOrderByOrderNo(this.result[i].orderNo).subscribe((res) => {
                 
                    console.log(res);
                    this.allOrders.push(res);
                });
            }
        })
    }
}