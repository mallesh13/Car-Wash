import { Routes } from "@angular/router";
import { WasherLoginComponent } from "./login.component";
import { WasherComponent } from "./washer.component";
import { WasherCurrentOrdersComponent } from './currentorders.component'

export const washerRoutes:Routes=[
    { path:"washerlogin", component: WasherLoginComponent},
    { path: "washer/home", component:WasherComponent},
    { path: "presentorders", component:WasherCurrentOrdersComponent}
]