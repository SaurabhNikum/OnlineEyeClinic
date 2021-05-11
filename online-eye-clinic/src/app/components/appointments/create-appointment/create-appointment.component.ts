import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from 'src/app/class/appointment';
import { AppointmentRequestService } from 'src/app/services/appointment-request.service';
import { AppointmentService } from 'src/app/services/appointment.service';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})
export class CreateAppointmentComponent implements OnInit {

  constructor(private router: Router,private appointmentService:AppointmentService,private appointmentRequestService:AppointmentRequestService,private route:ActivatedRoute) { }

  appointment:Appointment=new Appointment();
  requestId:number;

  ngOnInit(): void {
    this.requestId=this.route.snapshot.params['requestId'];
    this.appointment.patientId = this.route.snapshot.params['id'];
    this.appointment.patientEmail=this.route.snapshot.params['email'];
    this.appointment.appointmentDate=this.route.snapshot.params['date'];
    this.appointment.appointmentTime=this.route.snapshot.params['time'];
  }

  onSubmit()
  {
      this.appointmentService.createAppointment(this.appointment).subscribe(data=>{
      console.log(data);
      alert("Appointment has created successfully"); 
      this.appointmentRequestService.deleteAppointmentRequest(this.requestId).subscribe();
      this.router.navigate(['sendemail',this.appointment.patientEmail,this.appointment.appointmentDate,this.appointment.appointmentTime]);
    },
    error=>console.log(error));
  }

  goBack()
  {
    this.router.navigate(['appointment-request-list']);
  }
}
