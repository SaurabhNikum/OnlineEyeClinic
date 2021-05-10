import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from '../class/appointment';
import { Doctor } from '../class/doctor';
import { AppointmentService } from '../services/appointment.service';
import { DoctorService } from '../services/doctor.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  id:number;
  doctor:Doctor=new Doctor();
  appointments:Appointment[];
  

  constructor(private route: ActivatedRoute,private doctorService:DoctorService,private router:Router,
    private appointmentService:AppointmentService) { }

  ngOnInit(): void 
  {
    this.id = this.route.snapshot.params['id'];
    document.getElementById("list").style.visibility="hidden";
    this.doctorService.getDoctorById(this.id).subscribe(data=>this.doctor=data);
    
  }

  seeAppointment()
  {
    document.getElementById("list").style.visibility="visible";
    this.appointmentService.getAppointmentByDoctor(this.doctor.doctorId).subscribe(data=>this.appointments=data);
  }



}
