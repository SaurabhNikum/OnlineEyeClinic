import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from 'src/app/class/appointment';
import { AppointmentService } from 'src/app/services/appointment.service';

@Component({
  selector: 'app-appointment-details',
  templateUrl: './appointment-details.component.html',
  styleUrls: ['./appointment-details.component.css']
})
export class AppointmentDetailsComponent implements OnInit {

  id:number;
  appointment:Appointment=new Appointment();


  constructor(private route: ActivatedRoute,private appointmentService:AppointmentService,private router:Router) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    this.appointmentService.getAppointmentById(this.id).subscribe(data=>this.appointment=data);
  }

  goToAppointmentList(){
    this.router.navigate(['appointment-list']);
  }

  deleteAppointment(id:number)
  {
    this.appointmentService.deleteAppointment(id).subscribe(
      data=>
      {
        alert("Appointment has deleted successfully");
        this.goToAppointmentList();
      },
      error=>console.log(error));
    
  }
}
