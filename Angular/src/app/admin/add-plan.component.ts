import { Component, OnInit } from '@angular/core'
import { PlanInfo } from './plan'
import { AdminService } from './admin.service';
import { Router } from '@angular/router';
@Component({
    templateUrl: './add-plan.component.html',
    styleUrls:['./add-plan.component.css','./admin.component.css']
})
export class AddPlanComponent implements OnInit{

    plan : PlanInfo;

    constructor(private service: AdminService,
        private router:Router){}

    ngOnInit(){
        this.plan = new PlanInfo();
    }

    addPlan(){
        this.service.addPlanDetails(this.plan).subscribe((data)=>{
            console.log("success");
            this.plan=data;
            console.log(data);
            if(data!=null){
                alert("Plan Details Added");
                this.router.navigate(['/admin']);
            }
        })
    }
}