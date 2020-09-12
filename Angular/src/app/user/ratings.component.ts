import { Component, OnInit } from '@angular/core'
import { UserService } from './user.service'
import { RatingsAndReviews } from './ratings'
import { ActivatedRoute, Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
@Component({
    templateUrl: './ratings.component.html',
    styleUrls: ['ratings.component.css']
})

export class RatingsComponent implements OnInit{

    feedback:RatingsAndReviews;
    orderNo;
    constructor(private service:UserService,private routes:ActivatedRoute,private route:Router){}
    ngOnInit(){
        this.feedback= new RatingsAndReviews();
        this.orderNo = this.routes.snapshot.paramMap.get('orderNo');
        console.log(this.orderNo)
    }
    ratings(){
        const userName=JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        const fd= new FormData();
        fd.append("userName",userName);
        fd.append("orderNo",this.orderNo);
        fd.append("rating",this.feedback.rating.toString());
        fd.append("comments",this.feedback.comments);
        this.service.ratingAndReviews(fd).subscribe(data=>{
            console.log(data);
            if(data!=null){
                alert("thanks for feedback...");
                this.route.navigate(['/pastorders']);
            }
        })
    }
}