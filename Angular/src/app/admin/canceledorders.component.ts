import { Component, OnInit } from '@angular/core'
import { Booking } from '../user/Booking'
import { AdminService } from './admin.service'
@Component({
    templateUrl: './canceledorders.component.html',
    styleUrls: ['./canceledorders.component.css','./admin.component.css']
})

export class CanceledOrdersComponent implements OnInit{

    cancelOrders:Booking[];
    constructor(private service:AdminService){}
    ngOnInit(){
        this.service.getAllCanceledOrders().subscribe(data=>{
            this.cancelOrders=data;
            console.log(data);
        })
    }
}