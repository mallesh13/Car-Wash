import { Component, OnInit } from '@angular/core'
import { UserProfile } from './user';
import { AdminService } from './admin.service'
import { Router } from '@angular/router'

@Component({
    templateUrl:'./totalusers.component.html',
    styleUrls: ['./totalusers.component.css']
})
export class TotalUsersComponent implements OnInit{

    user: UserProfile;
    totalUsers : UserProfile[];
    constructor(private adminService: AdminService,
                private router:Router){}
    ngOnInit(){
        this.user = new UserProfile;
        this.adminService.totalUsers().subscribe((data)=>{
          this.totalUsers = data
            console.log(data);
        })
    }
}