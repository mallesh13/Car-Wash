import { Component, OnInit } from '@angular/core'
import { UserService } from './user.service'
import { UserProfile } from './user';
@Component({
    templateUrl:'./edit-profile.component.html',
    styleUrls:['./edit-profile.component.css']
})

export class EditProfileComponent implements OnInit {
 
    user:UserProfile;
    constructor(private service:UserService){}
    ngOnInit(){
    const userName=JSON.parse(JSON.stringify(sessionStorage.getItem("username")));  
    this.service.getUserDetails(userName).subscribe((data)=>{
        this.user=data;
        console.log(data);
    });
    }
    isTextFieldType: boolean;
    togglePasswordFieldType() {
        this.isTextFieldType = !this.isTextFieldType;        
      }
}