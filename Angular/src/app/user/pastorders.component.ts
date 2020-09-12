import { Component, OnInit } from '@angular/core'
import { Booking } from './Booking'
import { UserService } from './user.service'

@Component({
    templateUrl:'./pastorders.component.html',
    styleUrls: ['./pastorders.component.css']
})
export class PastOrdersComponent implements OnInit{

    info:Booking[];
    constructor(private service: UserService){}
    ngOnInit(){
        const userName=JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        this.service.pastOrdersForUser(userName).subscribe((data)=>{
            console.log(data);
            this.info=data;
        })
    }
}