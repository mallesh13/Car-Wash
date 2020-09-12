import { Routes } from '@angular/router';
import { LoginComponent } from './user-login.component';
import { SignupComponent } from './user-signup.component';
import { LogoutComponent} from './user-logout.component';
import { WelcomeComponent } from './welcome.component';
import { ContactUsComponent } from './contact.component';
import { BookingComponent } from './booking.component';
import { AdminComponent} from '../admin/admin.component'
import { CarDetailsComponent } from './cardetails.component'
import { PaymentComponent } from './payment.component'
import { EditProfileComponent } from './edit-profile.component';
import { CurrentOrdersComponent } from './currentorders.component'
import { PastOrdersComponent } from './pastorders.component'
import { RatingsComponent } from './ratings.component'
import { BookingWashComponent } from './bookingwash.component'

export const userRouts:Routes=[
    { path: "login", component: LoginComponent },
    { path: "signup", component: SignupComponent},
    { path: "logout", component: LogoutComponent},
    { path: "welcome", component: WelcomeComponent },
    { path: "contact", component: ContactUsComponent},
    { path: "booking", component: BookingComponent},
    { path: "admin", component: AdminComponent},
    { path: "getcardetails", component: CarDetailsComponent},
    { path: "payment/:orderNo", component:PaymentComponent},
    { path: "update", component:EditProfileComponent},
    { path: "currentorders", component:CurrentOrdersComponent},
    { path:"pastorders", component:PastOrdersComponent},
    { path: "reviewsandratings/:orderNo", component:RatingsComponent},
    { path: "", component:BookingWashComponent}
   
]