import { Routes } from '@angular/router'
import { AdminComponent } from './admin.component'
import { AddWasherComponent } from './add-washer.component'
import { TotalUsersComponent } from './totalusers.component'
import { AllFeedbackComponent } from './all-feedback.component'
import { TotalWashersComponent } from './totalwashers.component'
import { ServicesComponent } from './services.component'
import { AddPlanComponent } from './add-plan.component'
import { PendingOrdersComponent} from './pendingorders.component'
import { OrderComponent } from './order.component'
import { AcceptedOrdersComponent } from './acceptedorders.component'
import { UnderProcessOrdersComponent } from './underprocessorders.component'
import { CompletedOrdersComponent } from './completedorders.component'
import { CanceledOrdersComponent } from './canceledorders.component'
import { UsersRatingsComponent } from './usersratings.component'

export const adminRoutes:Routes =[
    { path: "admin", component: AdminComponent},
    { path: "addwasher", component: AddWasherComponent},
    { path: "allusers", component: TotalUsersComponent},
    { path: "allfeedbacks", component: AllFeedbackComponent},
    { path: "allwashers", component: TotalWashersComponent},
    { path: "services", component: ServicesComponent},
    { path:"admin/addserviceplan", component:AddPlanComponent},
    { path: "orders",component:OrderComponent},
    { path: "pendingorders", component: PendingOrdersComponent},
    { path: "acceptedorders", component:AcceptedOrdersComponent},
    { path: "underprocess", component:UnderProcessOrdersComponent},
    { path: "completedorders", component:CompletedOrdersComponent},
    { path:"canceledorders", component:CanceledOrdersComponent},
    { path: "usersratings", component:UsersRatingsComponent}
]