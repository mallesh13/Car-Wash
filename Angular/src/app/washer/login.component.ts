import { Component } from '@angular/core'
import { WasherServices } from './washer.services'
import { Router } from '@angular/router'
import { AuthenticationService } from '../user/user-authenticate.service'
@Component({
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class WasherLoginComponent {

    invalidLogin = false;
    ngOnInit(){

    }

    constructor(private service: WasherServices,
        private router: Router,
        private loginService: AuthenticationService) { }
    checkLogin() {
        let email = (<HTMLInputElement>document.getElementById("email")).value;
        let password = (<HTMLInputElement>document.getElementById("password")).value;

        if (email == 'admin' && password == 'password') {
            this.invalidLogin = this.loginService.adminauthenticate(true, email);
            this.router.navigate(['/admin'])
        }
        else {
           // alert("washer");
            this.service.washerLogin(email, password).subscribe((data) => {
                if(data!=null){
                this.invalidLogin = this.loginService.authenticate(true, email);
                //alert(" Washer logged in");
                this.router.navigate(['/washer/home']);
                }
            }
        )}
    }
}