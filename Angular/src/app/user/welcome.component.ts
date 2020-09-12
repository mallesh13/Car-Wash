import { Component, OnInit } from '@angular/core';
import { CarDetails } from './cardetails';
import { UserService } from './user.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  
    templateUrl:"./welcome.component.html",
    styleUrls: ["./welcome.component.css"]
})
export class WelcomeComponent implements OnInit{

    cardetails: CarDetails;
    text:string="";
    ngOnInit(){
        this.cardetails= new CarDetails;
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (var i = 0; i < 8; i++)
          this.text += possible.charAt(Math.floor(Math.random() * possible.length));
    }
    

    selectedFile: File = null;
    constructor(private userService: UserService,
        private router: Router,private sanitizer: DomSanitizer){}

    onFileSelected(event){
        this.selectedFile = <File>event.target.files[0];
    }
    addVehicleDetails(){
        const fd = new FormData();
        fd.append("image",this.selectedFile,this.selectedFile.name);
        fd.append("userName",JSON.parse(JSON.stringify(sessionStorage.getItem("username"))));
        fd.append("name",this.cardetails.name);
        fd.append("brand",this.cardetails.makerClass);
        fd.append("model",this.cardetails.model);
        fd.append("color",this.cardetails.color);
       
        this.userService.addVechile(fd).subscribe((data)=>{
            console.log(event);
            this.router.navigate(['/getcardetails']);
        })
    }

}