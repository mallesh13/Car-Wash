
import { Injectable, getDebugNode } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { UserProfile } from './user';
import { Observable } from 'rxjs';
import { ContactUs } from './contactUs';
import { CarDetails } from './cardetails';
import { FileResource } from './fileResource'
import { PaymentProfile } from './payment'
import { UpdateProfile } from './updateprofile';
import { BookingComponent } from './booking.component';
import { Booking } from './Booking';
import { TowardsPayment } from './towardspayment';
import { RatingsAndReviews } from './ratings'

@Injectable()
export class UserService{

    baseUrl = "http://localhost:8081";
    uploadUrl="http://localhost:8088";
    baseUrl2= "http://localhost:8085";

    constructor(private http: HttpClient){}

    registerNewUser(user: UserProfile):Observable<UserProfile>{
        return this.http.post<UserProfile>(this.baseUrl+"/user",user);
    }

    userLogin(email,password){
        return this.http.get(this.baseUrl+"/user/"+email+"/"+password);

    }

    registerFeedback(contact:ContactUs):Observable<ContactUs>{
        return this.http.post<ContactUs>(this.baseUrl+"/contact",contact);
    }

    addVechile(fd:FormData):Observable<CarDetails>{
       
        return this.http.post<CarDetails>(this.uploadUrl+"/user/addvehicledetails/"+fd.get("userName"),fd);
        
    }

    getVehicleDetails(userName:string):Observable<CarDetails[]>{
      // alert(userName);
        return this.http.get<CarDetails[]>(this.uploadUrl+"/vehicledetails/"+userName);
    }

    paymentMethod(fd:FormData):Observable<PaymentProfile>{
        alert(fd.get("userName"));
        return this.http.post<PaymentProfile>(this.baseUrl2+ "/payment/"+fd.get("orderNo")+"/"+fd.get("userName"), fd);
    }

    fetchAllById(id: string):Observable<Blob>{
        return this.http.get(this.uploadUrl+"/getvehicledetails/"+id, {responseType: 'blob'});
    }

    getUserDetails(userName:string):Observable<UserProfile>{
        return this.http.get<UserProfile>(this.baseUrl+"/getuserprofile/"+userName);
    }

    updateProfile(profile : UpdateProfile) : Observable<UpdateProfile>{
        return this.http.post<UpdateProfile>(this.baseUrl+"/updateprofile",profile);
    }

    bookWash(fd:FormData):Observable<Booking>{
        return this.http.post<Booking>(this.baseUrl+"/bookwash/"+fd.get("userName"),fd);
    }
    
    getOrdersByUser(userName:string):Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl+"/getordersforuser/"+userName);
    }

    getOrderByOrderNo(orderNo:string):Observable<Booking>{
        return this.http.get<Booking>(this.baseUrl+"/getordersforwasher/"+orderNo);
    }

    underProcessOrders(orderNo:string):Observable<Booking>{
        return this.http.get<Booking>(this.baseUrl+"/underprocessorders/"+orderNo);
    }

    underProcessOrdersByUser(userName:string):Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl+"/underprocessordersby/"+userName);
    }

    towardsPayment(fd:FormData):Observable<TowardsPayment>{
        return this.http.post<TowardsPayment>(this.baseUrl+"/towardsPayment",fd);
    }

    finalOrderUpdate(orderNo:string):Observable<Booking>{
        alert(orderNo);
        return this.http.get<Booking>(this.baseUrl+"/finalupdateorder/"+orderNo);
    }

    pastOrdersForUser(userName:string):Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl+"/userpastorders/"+userName);
    }

    pendingOrdersForUser(userName:string):Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl+"/pendingordersfor/"+userName);
    }

    cancelOrder(userName,orderNo):Observable<string>{
        return this.http.get<string>(this.baseUrl+"/cancelorder/"+userName+"/"+orderNo);
    }

    resheduleOrder(userName,orderNo,date):Observable<string>{
        return this.http.get<string>(this.baseUrl+"/resheduleorder/"+userName+"/"+orderNo+"/"+date);
    }

    ratingAndReviews(fd:FormData):Observable<RatingsAndReviews>{
        return this.http.post<RatingsAndReviews>(this.baseUrl+"/ratingsandreviews",fd);
    }
}