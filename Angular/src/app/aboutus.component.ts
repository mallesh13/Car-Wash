import { Component, OnInit } from '@angular/core'
import { AdminService } from './admin/admin.service';
import { PlanInfo } from './admin/plan';


@Component({
    templateUrl: './aboutus.component.html',
    styleUrls:['./aboutus.component.css']
})
export class AboutUsComponent implements OnInit{

    plansData:PlanInfo[];
    constructor(private service:AdminService){}
    ngOnInit(){
        this.service.totalPlans().subscribe(data=>{
            this.plansData=data;
            console.log(data);
        })
    }
}