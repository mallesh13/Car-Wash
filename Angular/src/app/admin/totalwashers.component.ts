import { Component, OnInit } from '@angular/core'
import { WasherProfile } from './washer'
import { AdminService } from './admin.service' 
import { Routes, Router } from '@angular/router';
@Component({
    templateUrl:'./totalwashers.component.html',
    styleUrls:['./totalwashers.component.css','./totalusers.component.css']
})
export class TotalWashersComponent{
    washer:WasherProfile;
    totalWashers:WasherProfile[];
    constructor(private service:AdminService,
        private routes:Router){}

    ngOnInit(){
        this.washer= new WasherProfile();
        this.service.totalWashers().subscribe((data)=>{
            this.totalWashers=data;
            console.log(data);
        })
    }

    deleteWasher(){
        //alert("welcome");
        let email = (<HTMLInputElement>document.getElementById("email")).value;
        this.service.deleteWasher(email).subscribe((data)=>{
           alert("washer deleted");
            this.routes.navigate(["/admin"]);
        })

    }

}