import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/class/appointment';
import { AppointmentService } from 'src/app/services/appointment.service';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})
export class CreateAppointmentComponent implements OnInit {

  constructor(private router: Router,private appointmentService:AppointmentService) { }

  appointment:Appointment=new Appointment();

  ngOnInit(): void {
  }

  saveAppointment()
  {
      this.appointmentService.createAppointment(this.appointment).subscribe(data=>{
      console.log(data);
      alert("Appointment has created successfully");
      this.appointment=new Appointment();
      this.goToAppointmentList();
    },
    error=>console.log(error));
  }
  
  goToAppointmentList(){
    this.router.navigate(['appointment-list']);
  }

  onSubmit(){
    this.saveAppointment();
  }

}
