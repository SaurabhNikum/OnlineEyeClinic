import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/class/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctor-list-user',
  templateUrl: './doctor-list-user.component.html',
  styleUrls: ['./doctor-list-user.component.css']
})
export class DoctorListUserComponent implements OnInit {

  doctors:Doctor[];
  name:string;

  constructor(private router:Router,private doctorService:DoctorService) { }

  ngOnInit(): void 
  {
    this.getDoctor();
  }

  doctorByName()
  {
    this.doctorService.getDoctorByName(this.name).subscribe(data=>this.doctors=data);
  }
  getDoctor()
  {
    this.doctorService.getDoctorList().subscribe(data=>this.doctors=data);
  }



}
