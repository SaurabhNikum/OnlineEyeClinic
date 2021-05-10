import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentRequest } from 'src/app/class/appointment-request';
import { AppointmentRequestService } from 'src/app/services/appointment-request.service';

@Component({
  selector: 'app-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.css']
})
export class RequestListComponent implements OnInit {

  constructor(private appointmentRequestService:AppointmentRequestService,private router:Router) { }

  appointmentRequests:AppointmentRequest[];

  ngOnInit(): void 
  {
    this.getAppointmentRequestList();
  }

  getAppointmentRequestList()
  {
    this.appointmentRequestService.getAppointmentRequest().subscribe(data=>this.appointmentRequests=data);
  }

  deleteAppointmentRequest(id:number,date:Date,time:Time,email:string)
  {
    this.appointmentRequestService.deleteAppointmentRequest(id).subscribe(
      data=>{alert("Appointment request has deleted successfully");
      this.router.navigate(['sendregretionemail',email,date,time,])
      this.getAppointmentRequestList();},
      error=>{
        console.log(error);
        alert("Deletion failed")
        this.getAppointmentRequestList();}
    );
    
  }

  acceptAppointmentRequest(requestId:number,id:number,date:Date,time:Time,email:String)
  {
    this.router.navigate(['create-appointment',requestId,id,date,time,email]);
  }
}
