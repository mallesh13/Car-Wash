import { Component, OnInit } from '@angular/core'
import { PaymentProfile } from './payment'
import { UserService } from './user.service'
import { Router, ActivatedRoute } from '@angular/router'
import { TowardsPayment } from './towardspayment';

@Component({
    templateUrl: './payment.component.html',
    styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

    payments: PaymentProfile;
    result: TowardsPayment;
    orderNo: string;
    constructor(private service: UserService,
        private route: Router, private routes: ActivatedRoute) {
    }
    ngOnInit() {
        this.payments = new PaymentProfile();
        this.orderNo = this.routes.snapshot.paramMap.get('orderNo');
        console.log(this.orderNo)
    }

    paymentMethod() {

        const fd = new FormData();
        fd.append("orderNo", this.orderNo);
        fd.append("userName", JSON.parse(JSON.stringify(sessionStorage.getItem("username"))));
        fd.append("firstname", this.payments.firstname);
        fd.append("bankname", this.payments.bankname);
        fd.append("expmonth", this.payments.expmonth);
        fd.append("expyear", this.payments.expyear);
        fd.append("cardname", this.payments.cardname);
        fd.append("cardnumber", this.payments.cardnumber);
        fd.append("cvv", this.payments.cvv);
        this.service.paymentMethod(fd).subscribe((data) => {
            console.log("success");
            if (data != null) {
                
                this.route.navigate(['/reviewsandratings/'+data.orderNo]);
            }
        });
        
        this.service.finalOrderUpdate(this.orderNo).subscribe(res => {
            console.log(res);
        })
    }

}