import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/class/appointment';
import { AppointmentService } from 'src/app/services/appointment.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  constructor(private appointmentService:AppointmentService,private router:Router) { }

  appointments:Appointment[];
  appDate:Date;

  ngOnInit(): void 
  {
    this.getAppointments();
  }

  getAppointments()
  {
    this.appointmentService.getAppointment().subscribe(data=>this.appointments=data);
  }

  appointmentDetails(id:number)
  {
    this.router.navigate(['appointment-details', id]);
  }

  appointmentByDate()
  {
    this.appointmentService.getAppointmentByDate(this.appDate).subscribe(data=>
      this.appointments=data);
  }


  deleteAppointment(id:number)
  {
    this.appointmentService.deleteAppointment(id).subscribe(
      data=>{alert("Appointment has deleted successfully");
      this.getAppointments();},
      error=>{
        console.log(error);
        alert("Deletion failed")
        this.getAppointments();}
    );
    
  }
}
