import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { WasherProfile } from './washer';
import { Observable } from 'rxjs';
import { UserProfile } from '../user/user';
import { ContactUs } from '../user/contactUs';
import { PlanInfo } from './plan';
import { Booking } from '../user/Booking';
import { AssignWasher } from './assignwasher';
import { RatingsAndReviews } from '../user/ratings';

@Injectable()
export class AdminService {

    baseUrl = "http://localhost:8082";
    baseUrl1 = "http://localhost:8081";
    washer = "http://localhost:8084";

    constructor(private http: HttpClient) { }

    addNewWasher(washer: WasherProfile): Observable<WasherProfile> {
       // alert(washer);
        return this.http.post<WasherProfile>(this.washer + "/addwasher", washer);
    }

    totalUsers(): Observable<UserProfile[]> {
        return this.http.get<UserProfile[]>(this.baseUrl1 + "/allusers");
    }

    totalContacts(): Observable<ContactUs[]> {
        return this.http.get<ContactUs[]>(this.baseUrl1 + "/allfeedbacks");
    }

    totalWashers(): Observable<WasherProfile[]> {
        return this.http.get<WasherProfile[]>(this.washer + "/allwashersdetails");
    }

    deleteWasher(email) {
        return this.http.get(this.washer + "/deleteWasher/" + email);
    }

    addPlanDetails(plan: PlanInfo): Observable<PlanInfo> {
        return this.http.post<PlanInfo>(this.baseUrl + "/addplan", plan);
    }

    totalPlans(): Observable<PlanInfo[]> {
        return this.http.get<PlanInfo[]>(this.baseUrl + "/getplandetails")
    }

    deletePlan(name): Observable<PlanInfo> {
        return this.http.get<PlanInfo>(this.baseUrl + "/deleteplan/" + name);
    }
    getPlanByname(name): Observable<PlanInfo> {
        return this.http.get<PlanInfo>(this.baseUrl + "/getplan/" + name);
    }

    allPendingOrders(): Observable<Booking[]> {
        return this.http.get<Booking[]>(this.baseUrl1 + "/pendingorders");
    }

    assignNewWasher(fd: FormData): Observable<AssignWasher> {
        return this.http.post<AssignWasher>(this.baseUrl + "/assignwasher", fd);
    }

    getAllAcceptedOrders():Observable<AssignWasher[]>{
        return this.http.get<AssignWasher[]>(this.baseUrl+"/getallAcceptedorders");
    }

    getAllUnderProcessOrders():Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl1+"/allunderprocessorders");
    }

    getWasherData(orderNo:string):Observable<AssignWasher>{
        return this.http.get<AssignWasher>(this.baseUrl+"/getwasherdataby/"+orderNo);
    }
    getAllCompletedOrders():Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl1+"/allcompletedorders");
    }

    getAllCanceledOrders():Observable<Booking[]>{
        return this.http.get<Booking[]>(this.baseUrl1+"/canceledorders");
    }

    getAllRatings():Observable<RatingsAndReviews[]>{
        return this.http.get<RatingsAndReviews[]>(this.baseUrl1+"/allratings");
    }
}