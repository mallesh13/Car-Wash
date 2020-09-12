import { NgModule } from "@angular/core";
import { LoginComponent } from "./user-login.component";
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { userRouts } from "./user.routs";
import { UserService } from "./user.service";
import { SignupComponent } from './user-signup.component';
import { WelcomeComponent } from './welcome.component';
import { ContactUsComponent } from './contact.component';
import { BookingComponent } from './booking.component';
import { PaymentComponent } from './payment.component';
import { CarDetailsComponent } from './cardetails.component';
import { EditProfileComponent } from './edit-profile.component';
import { AdminService } from '../admin/admin.service';
import { CurrentOrdersComponent } from './currentorders.component';
import { PastOrdersComponent } from './pastorders.component';
import { RatingsComponent } from './ratings.component';
import { BookingWashComponent } from './bookingwash.component';

@NgModule({
    declarations: [LoginComponent, SignupComponent, WelcomeComponent, ContactUsComponent,
        BookingComponent, PaymentComponent, CarDetailsComponent, EditProfileComponent, 
        CurrentOrdersComponent,PastOrdersComponent,RatingsComponent, BookingWashComponent],
    imports: [BrowserModule, FormsModule, HttpClientModule, RouterModule.forChild(userRouts)],
    exports: [LoginComponent, SignupComponent, WelcomeComponent, ContactUsComponent,
        BookingComponent, PaymentComponent, CarDetailsComponent, EditProfileComponent, 
        CurrentOrdersComponent,PastOrdersComponent,RatingsComponent,BookingWashComponent],
    providers: [UserService, AdminService]
})
export class UserModule {

}