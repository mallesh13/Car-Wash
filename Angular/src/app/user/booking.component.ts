import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin/admin.service';
import { PlanInfo } from '../admin/plan';
import {Booking } from './Booking'
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './booking.component.html',
    styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

    book:Booking;
    plan: PlanInfo;
    totalPlans: PlanInfo[];
    text:string="";
    constructor(private service: AdminService,private userService:UserService,private routes:Router) { }
    ngOnInit() {
        this.book=new Booking();
        this.service.totalPlans().subscribe((data) => {
            this.totalPlans = data;
            console.log(data);
        });
       
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (var i = 0; i < 5; i++)
          this.text += possible.charAt(Math.floor(Math.random() * possible.length));
      }
      
    booking(){
       
        const fd= new FormData();
        fd.append("orderNo",this.book.orderNo);
        fd.append("userName",JSON.parse(JSON.stringify(sessionStorage.getItem("username"))));
        fd.append("name",this.book.name);
        fd.append("number",this.book.number);
        fd.append("address",this.book.address);
        fd.append("maker",this.book.maker);
        fd.append("model",this.book.model);
        fd.append("color",this.book.color);
        fd.append("plan",this.book.plan);
        fd.append("date",this.book.date);
        this.userService.bookWash(fd).subscribe((data)=>{
            alert("Booking is Done");
            console.log("Booking wash Success");
            if(data!=null){
                this.routes.navigate(["/currentorders"]);
            }
        });
    }
}