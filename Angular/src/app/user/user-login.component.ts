import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { Router } from '@angular/router';
import { AuthenticationService } from './user-authenticate.service'

@Component({
  templateUrl: "./user-login.component.html",
  styleUrls: ["./user-login.component.css"]
})
export class LoginComponent {

  invalidLogin = false;

  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private userService: UserService) { }

  ngOnInit() {
  }

  checkLogin() {
    let email = (<HTMLInputElement>document.getElementById("email")).value;
    let password = (<HTMLInputElement>document.getElementById("password")).value;
    if (email == 'admin' && password == 'password') {
      this.invalidLogin = this.loginservice.adminauthenticate(true, email);
      this.router.navigate(['/admin'])
    }
    else {
      this.userService.userLogin(email, password).subscribe((data) => {
        // if(data!=null) {

        //     if (email=='admin'&& password=='password') {
        //     this.invalidLogin = this.loginservice.adminauthenticate(true,email);
        //     this.router.navigate(['/admin'])
        //   }
        //   else{
        this.invalidLogin = this.loginservice.authenticate(true, email);
        //alert("logged in");
        this.router.navigate(['/welcome']);
        //   }
        // }
        // else
        // this.invalidLogin = true;

      })

    }
  }
}