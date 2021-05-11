import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppointmentRequest } from 'src/app/class/appointment-request';
import { AppointmentRequestService } from 'src/app/services/appointment-request.service';

@Component({
  selector: 'app-appointment-request',
  templateUrl: './appointment-request.component.html',
  styleUrls: ['./appointment-request.component.css']
})
export class AppointmentRequestComponent implements OnInit {

  constructor(private route:ActivatedRoute,private router: Router,private appointmentRequestService:AppointmentRequestService) { }

  appointmentRequest:AppointmentRequest=new AppointmentRequest();


  ngOnInit(): void {
    this.appointmentRequest.patientId=this.route.snapshot.params['id'];
    this.appointmentRequest.patientEmail=this.route.snapshot.params['email'];
  }

  saveAppointmentRequest()
  {
      this.appointmentRequestService.createAppointmentRequest(this.appointmentRequest).subscribe(data=>{
      console.log(data);
      alert("Appointment request  sent successfully");
      this.router.navigate(['patientuser',this.appointmentRequest.patientId])
      this.appointmentRequest=new AppointmentRequest();
    },
    error=>console.log(error));
  }

  onSubmit(){
    this.saveAppointmentRequest();
  }

  goBack(id:number)
  {
    this.router.navigate(['patientuser',id])
  }

}
