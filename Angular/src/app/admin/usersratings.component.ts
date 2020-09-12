import { Component, OnInit } from '@angular/core'
import { RatingsAndReviews } from '../user/ratings'
import { AdminService } from './admin.service' 

@Component({
    templateUrl:'./usersratings.component.html',
    styleUrls: ['./usersratings.component.css','./admin.component.css']
})
export class UsersRatingsComponent implements OnInit{

    ratings:RatingsAndReviews[];
    constructor(private service:AdminService){}
    ngOnInit(){
        this.service.getAllRatings().subscribe(data=>{
            this.ratings=data;
            console.log(data);
        })
    }
}