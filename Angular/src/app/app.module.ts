import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { UserModule } from './user/user.module';
import { RouterModule } from '@angular/router';
import { appRoutes } from './app.routs';
import { AboutUsComponent } from './aboutus.component';
import { AdminModule } from './admin/admin.module'
import { WasherModule } from './washer/washer.module'
@NgModule({
  declarations: [
    AppComponent,AboutUsComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes), UserModule,AdminModule,WasherModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
