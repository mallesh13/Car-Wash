import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { washerRoutes } from './washer.routes';
import { WasherLoginComponent } from './login.component';
import { WasherComponent } from './washer.component';
import { WasherServices } from './washer.services';
import { WasherCurrentOrdersComponent } from './currentorders.component';

@NgModule({

    declarations: [WasherLoginComponent,WasherComponent,WasherCurrentOrdersComponent],
    imports: [BrowserModule, FormsModule, HttpClientModule, RouterModule.forChild(washerRoutes)],
    exports: [WasherComponent,WasherLoginComponent,WasherCurrentOrdersComponent],
    providers: [WasherServices]
})
export class WasherModule {

}