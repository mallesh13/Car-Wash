import { Component, OnInit } from '@angular/core'
import { PlanInfo } from './plan'
import { AdminService } from './admin.service';
import { Router } from '@angular/router';

@Component({
    templateUrl: './services.component.html',
    styleUrls: ['./services.component.css', './admin.component.css', './totalwashers.component.css']
})
export class ServicesComponent implements OnInit {

    totalPlans: PlanInfo[];

    constructor(private service: AdminService,
        private routes: Router) {

    }
    ngOnInit() {
        this.service.totalPlans().subscribe((data) => {
            this.totalPlans = data;
            console.log(data);
        })
    }

    deletePlan() {
        let name = (<HTMLInputElement>document.getElementById("plan")).value;
        this.service.deletePlan(name).subscribe((data)=>{
            alert(name+" plan has Deleted");
            this.routes.navigated=false;
        });
        window.location.reload();
    }
   
}