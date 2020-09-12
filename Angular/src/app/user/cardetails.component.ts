import { Component, OnInit } from '@angular/core'
import { CarDetails } from './cardetails'
import { UserService } from './user.service';
import { FileResource } from './fileResource';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
    templateUrl: './cardetails.component.html',
    styleUrls: ['./cardetails.component.css']
})
export class CarDetailsComponent implements OnInit {

  
    cardetails: CarDetails[];
    totalDetails: FileResource[];

    base64Data:any;
    image:any;
    constructor(private service: UserService, private sanitizer: DomSanitizer,
        private router:Router) { }
    ngOnInit() {

        const userName = JSON.parse(JSON.stringify(sessionStorage.getItem("username")));
        this.service.getVehicleDetails(userName).subscribe((data) => {
            this.cardetails = data;
            console.log(data);
            let myurl;
            for(let i in this.cardetails){
               
                this.base64Data= this.cardetails[i].image;;
                this.cardetails[i].image='data:image/jpeg;Base64,' + this.base64Data;
                console.log(this.cardetails[i])
               // this.url2.push(this.image);
            }
        });

    }
}


