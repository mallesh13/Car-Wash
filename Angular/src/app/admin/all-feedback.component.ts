import { Component, OnInit } from "@angular/core";
import { ContactUs } from "./contactus"
import { AdminService } from "./admin.service"
import { Routes } from "@angular/router"

@Component({
    templateUrl: './all-feedback.component.html',
    styleUrls: ['./all-feedback.component.css']
})
export class AllFeedbackComponent implements OnInit{

    contactus : ContactUs;
    totalcontacts : ContactUs[];
    
    constructor(private service:AdminService){}
    ngOnInit(){

        this.contactus=new ContactUs;
        this.service.totalContacts().subscribe((data)=>{
            this.totalcontacts=data;
            console.log(data);
        })
    }
}