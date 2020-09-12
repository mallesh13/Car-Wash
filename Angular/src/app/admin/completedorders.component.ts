import { Component, OnInit } from '@angular/core'
import { Booking } from '../user/Booking'
import { AdminService } from './admin.service'

@Component({
    templateUrl:'./completedorders.component.html',
    styleUrls: ['./completedorders.component.css','./admin.component.css']
})
export class CompletedOrdersComponent implements OnInit{

    info: Booking[];
    constructor(private service:AdminService){}
    ngOnInit(){
        this.service.getAllCompletedOrders().subscribe(data=>{
            console.log(data);
            this.info=data;
        })
    }
}