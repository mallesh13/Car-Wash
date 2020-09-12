import { Component, OnInit } from '@angular/core'
import { Booking } from './Booking'
import { UserService } from './user.service'
import { AdminService } from '../admin/admin.service';
import { AssignWasher } from '../admin/assignwasher';
import { TowardsPayment } from './towardspayment'
import { Router, NavigationExtras, NavigationEnd } from '@angular/router';

@Component({
    templateUrl: './currentorders.component.html',
    styleUrls: ['./currentorders.component.css']
})
export class CurrentOrdersComponent implements OnInit {

    info: TowardsPayment;
    orders: Booking[];
    underProcessOrders: Booking[];
    resultWasher: AssignWasher;
    pendingOrders: Booking[];
    constructor(private service: UserService, private adminService: AdminService, private routes: Router) {
        
      }
    ngOnInit() {
        this.info = new TowardsPayment();
        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        this.service.getOrdersByUser(userName).subscribe((data) => {
            console.log(data);
            this.orders = data;
        })
        this.service.underProcessOrdersByUser(userName).subscribe((result) => {
            console.log(result);
            this.underProcessOrders = result;
        })
        this.service.pendingOrdersForUser(userName).subscribe((res) => {
            console.log(res);
            this.pendingOrders = res;
        })

        
    };

    towardsPayment() {
        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        let orderNo = (<HTMLInputElement>document.getElementById("orderNo")).value;
        this.adminService.getWasherData(orderNo).subscribe((data) => {
            console.log(data);
            this.resultWasher = data;
            const fd = new FormData();
            const washerEmail = this.resultWasher.washerEmail;

            fd.append("orderNo", this.info.orderNo);
            fd.append("userName", userName);
            fd.append("washerEmail", washerEmail);

            this.service.towardsPayment(fd).subscribe(data => {
                console.log(data);
                this.routes.navigate(['/payment/' + data.orderNo]);
            });
        });

    }

    cancelOrder(){
        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        let orderNo= (<HTMLInputElement>document.getElementById("cancelOrderNo")).value;
        this.service.cancelOrder(userName,orderNo).subscribe(data=>{
            console.log(data);
            alert("orderNo:"+orderNo+" is canceled...");
        })
        window.location.reload();
    }

    resheduleOrder(){
        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        let orderNo= (<HTMLInputElement>document.getElementById("resheduleOrderNo")).value;
        let date= (<HTMLInputElement>document.getElementById("resheduleDate")).value;
        this.service.resheduleOrder(userName,orderNo,date).subscribe(data=>{
            console.log(data);
            alert("order is Resheduled");
           
        });
        window.location.reload();
    }
   
}