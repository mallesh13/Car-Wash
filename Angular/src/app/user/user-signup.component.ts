import { Component, OnInit } from '@angular/core';
import { UserProfile } from './user';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
    templateUrl : "./user-signup.component.html",
    styleUrls :["./user-signup.component.css"]   
})
export class SignupComponent implements OnInit{
    user:UserProfile;

    constructor(private userService: UserService,
        private router: Router){}

    ngOnInit(){
        this.user = new UserProfile();
    }

    registerNewUser(){
     alert("registration method");
        this.userService.registerNewUser(this.user).subscribe((data)=>{
            console.log("success");
            if(data!=null){
               alert("done");
                this.router.navigate(["/login"]);
            }
            
        });
    }
}