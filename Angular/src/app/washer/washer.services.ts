import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { AssignWasher } from '../admin/assignwasher';
import { Observable } from 'rxjs';
@Injectable()
export class WasherServices{

    baseUrl="http://localhost:8084";
    adminUrl="http://localhost:8082";

    constructor(private http:HttpClient){}

    washerLogin(email,password){
        return this.http.get(this.baseUrl+"/washer/"+email+"/"+password);
    }
    washerOrder(userName:string):Observable<AssignWasher[]>{
        return this.http.get<AssignWasher[]>(this.adminUrl+"/assignwasher/"+userName);
    }
    washerStatusUpdate(orderNo):Observable<AssignWasher>{
        return this.http.get<AssignWasher>(this.adminUrl+"/washerAccept/"+orderNo);
    }
    washerReject(orderNo):Observable<AssignWasher>{
        return this.http.get<AssignWasher>(this.adminUrl+"/rejectorder/"+orderNo);
    }
    washerCurrentOrders(userName):Observable<AssignWasher[]>{
        return this.http.get<AssignWasher[]>(this.adminUrl+"/washercurrentorders/"+userName);
    }
}