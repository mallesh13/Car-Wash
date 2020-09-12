import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './user-authenticate.service';

@Component({
    templateUrl : './user-logout.component.html'
})
export class LogoutComponent{

    constructor(
        private authentocationService: AuthenticationService,
        private router: Router) {
    
      }
    
      ngOnInit() {
        this.authentocationService.logOut();
        this.router.navigate(['']);
      }
    
}