import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './user/user-authenticate.service';
import { UserService } from './user/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(public loginService: AuthenticationService, private userService: UserService, private sanitizer: DomSanitizer, private route: ActivatedRoute,
    private router: Router) { }
  ngOnInit() {
  }
}
