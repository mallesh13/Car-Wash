import { Component, OnInit } from '@angular/core'
import { Booking } from '../user/Booking'
import { AdminService } from './admin.service';

@Component({
    templateUrl:'./underprocessorders.component.html',
    styleUrls: ['./underprocessorders.component.css','./admin.component.css']
})
export class UnderProcessOrdersComponent implements OnInit{

    orders:Booking[];
    constructor(private service:AdminService){}
    ngOnInit(){
        this.service.getAllUnderProcessOrders().subscribe((data)=>{
            this.orders=data;
            console.log(data);
        })
    }
}