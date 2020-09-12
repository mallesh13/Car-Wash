import { Routes } from "@angular/router";
import { AppComponent } from './app.component';
import { AboutUsComponent } from './aboutus.component';

export const appRoutes : Routes=[
   
    { path:"app", component: AppComponent },
    { path: "about", component: AboutUsComponent}

];