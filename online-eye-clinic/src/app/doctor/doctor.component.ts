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
    this.doctorService.getDoctorById(this.id).subscribe(data=>this.doctor=data);
    document.getElementById("alist").style.visibility="hidden";
    
  }

  showAppointment()
  {
    document.getElementById("alist").style.visibility="visible";
    this.getAppointment();
  }

  hideAppointment()
  {
    document.getElementById("alist").style.visibility="hidden";
  }

  getAppointment()
  {
    this.appointmentService.getAppointmentByDoctor(this.doctor.doctorId).subscribe(data=>this.appointments=data);
  }

  updateDoctor(id:number)
  {
    this.router.navigate(['update-doctor', id]);
  }



}
