import { Component } from '@angular/core'
import { WasherProfile } from './washer'
import { AdminService } from './admin.service'
import { Router } from '@angular/router'

@Component({
    templateUrl: './add-washer.component.html',
    styleUrls: ['./add-washer.component.css']
}) 
export class AddWasherComponent{
        
    washer:WasherProfile;
    constructor(private service: AdminService,
        private router:Router){}

        ngOnInit(){
            this.washer = new WasherProfile();
        }    
    addNewWasher(){
       // alert("adding washer method");
        this.service.addNewWasher(this.washer).subscribe((data)=>{
            console.log("success");
            if(data!=null){
                alert("washer details added");
                this.router.navigate(['/admin']);
            }
        })
    }
}