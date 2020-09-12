import { Component, OnInit } from '@angular/core';
import { ContactUs } from './contactUs';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './contact.component.html',
    styleUrls: ['./contact.component.css']

})
export class ContactUsComponent implements OnInit{
    contact :ContactUs;
    
    constructor(private userService: UserService,
        private router: Router){}

    ngOnInit(){
        this.contact = new ContactUs();
    }

    registerFeedback(){
    // alert("feedback registration method");
        this.userService.registerFeedback(this.contact).subscribe((data)=>{
            console.log("success");
            if(data!=null){
               alert("Hello "+this.contact.name+"\nmessage has been sent");
                this.router.navigate([""]);
            }
            
        });
    }
}