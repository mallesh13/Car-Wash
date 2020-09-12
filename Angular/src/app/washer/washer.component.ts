import { Component, OnInit } from '@angular/core'
import { WasherServices } from './washer.services';
import { AssignWasher } from '../admin/assignwasher';
import { Booking } from '../user/Booking';
import { UserService } from '../user/user.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './washer.component.html',
    styleUrls: ['./washer.component.css']
})
export class WasherComponent implements OnInit {
    orderWash1: AssignWasher;
    orderWash: AssignWasher;
    orders: AssignWasher[];
    orderInfo: Booking;
    allOrdersInfo: Object[] = [];
    size: number;
    constructor(private service: WasherServices, private userService: UserService,
        private routes: Router) {

    }
    ngOnInit() {
        this.orderWash1 = new AssignWasher();
        this.orderWash = new AssignWasher();
        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        this.service.washerOrder(userName).subscribe((data) => {
            this.orders = data;
            
            console.log(data);
            for (let i = 0; i <= this.orders.length; ++i) {
                this.userService.getOrderByOrderNo(this.orders[i].orderNo).subscribe((res) => {
                    this.orderInfo = res;
                    console.log(res);
                    this.allOrdersInfo.push(res);
                });
            }

        });
    }

    washerDecision() {
        let orderNo = (<HTMLInputElement>document.getElementById("orderNo")).value;
        this.service.washerStatusUpdate(orderNo).subscribe((data) => {
            console.log(data);
            this.routes.navigate(['/washer/home']);
        });
        this.userService.underProcessOrders(orderNo).subscribe((result)=>{
            console.log(result);
        });
        window.location.reload();
    }
    rejectOrder(){
        let orderNo = (<HTMLInputElement>document.getElementById("order")).value;
        this.service.washerReject(orderNo).subscribe((data)=>{
            console.log(data);
        });
        window.location.reload();
    }
}