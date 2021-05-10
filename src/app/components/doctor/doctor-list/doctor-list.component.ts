import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/class/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {

  doctors:Doctor[];
  name:string;

  constructor(private router:Router,private doctorService:DoctorService) { }

  ngOnInit(): void 
  {
    this.getDoctor();
  }

  getDoctor()
  {
    this.doctorService.getDoctorList().subscribe(data=>this.doctors=data);
  }

  doctorDetails(id:number)
  {
    this.router.navigate(['doctor-details', id]);
  }

  updateDoctor(id:number)
  {
    this.router.navigate(['update-doctor', id]);
  }

  doctorByName()
  {
    this.doctorService.getDoctorByName(this.name).subscribe(data=>this.doctors=data);
  }

  deleteDoctor(id:number)
  {
    this.doctorService.deleteDoctor(id).subscribe(
      ()=>
      {
        alert("Doctor has deleted successfully");
        this.getDoctor();
      },
      error=>
      {
        alert("update failed");
        console.log(error);
      });
  }

}
