import { NgModule } from "@angular/core";
import { AdminComponent } from "./admin.component";
import { AdminService } from "./admin.service";
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { adminRoutes } from "./admin.routs";
import { AddWasherComponent } from './add-washer.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TotalUsersComponent } from './totalusers.component';
import { AllFeedbackComponent } from './all-feedback.component';
import { TotalWashersComponent } from './totalwashers.component';
import { ServicesComponent } from './services.component';
import { AddPlanComponent } from './add-plan.component';
import { PendingOrdersComponent } from './pendingorders.component';
import { OrderComponent } from './order.component';
import { AcceptedOrdersComponent } from './acceptedorders.component';
import { UnderProcessOrdersComponent } from './underprocessorders.component';
import { CompletedOrdersComponent } from './completedorders.component';
import { CanceledOrdersComponent } from './canceledorders.component';
import { UsersRatingsComponent } from './usersratings.component';


@NgModule({
    declarations: [AdminComponent, AddWasherComponent, TotalUsersComponent, AllFeedbackComponent,
        TotalWashersComponent, ServicesComponent, AddPlanComponent, OrderComponent, PendingOrdersComponent,
        AcceptedOrdersComponent, UnderProcessOrdersComponent, CompletedOrdersComponent,
        CanceledOrdersComponent,UsersRatingsComponent],
    imports: [BrowserModule, FormsModule, HttpClientModule, RouterModule.forChild(adminRoutes)],
    exports: [AdminComponent, AddWasherComponent, TotalUsersComponent, AllFeedbackComponent,
        TotalWashersComponent, ServicesComponent, AddPlanComponent, OrderComponent, PendingOrdersComponent,
        AcceptedOrdersComponent, UnderProcessOrdersComponent, CompletedOrdersComponent,
        CanceledOrdersComponent,UsersRatingsComponent],
    providers: [AdminService]
})
export class AdminModule {

}