import { Component, OnInit } from '@angular/core'
import { WasherServices } from './washer.services'
import { UserService } from '../user/user.service'
import { AssignWasher } from '../admin/assignwasher';
import { Booking } from '../user/Booking';
import { BookingComponent } from '../user/booking.component';

@Component({
    templateUrl: './currentorders.component.html',
    styleUrls: ['./currentorders.component.css','./washer.component.css']
})
export class WasherCurrentOrdersComponent implements OnInit{

    orders:AssignWasher[];
    orderInfo:Booking;
    allOrdersInfo:Object[]=[];
    constructor(private service: WasherServices, private userService: UserService) {}
    ngOnInit(){
        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        this.service.washerCurrentOrders(userName).subscribe((data) => {
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
}